package supercell.api.wrapper.essentials.connector;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import static org.apache.commons.io.FileUtils.write;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import static supercell.api.wrapper.essentials.connector.FilesystemCachedConnector.CACHE_TIMEOUT;

import static wiremock.org.apache.http.HttpHeaders.AUTHORIZATION;
import static wiremock.org.apache.http.HttpStatus.SC_INTERNAL_SERVER_ERROR;
import static wiremock.org.apache.http.HttpStatus.SC_OK;

import static java.lang.System.currentTimeMillis;
import static java.nio.charset.StandardCharsets.UTF_8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.junit.jupiter.MockitoExtension;

import supercell.api.wrapper.essentials.common.Request;
import supercell.api.wrapper.essentials.common.Response;

import java.io.File;
import java.io.IOException;
import java.util.function.Consumer;

@ExtendWith(MockitoExtension.class)
class FilesystemCachedConnectorTest extends ConnectorTestBase {

    private static final String JSON =
            """
            {
                "reason": "reason",
                "message": "message"
            }
            """;

    private FilesystemCachedConnector unitUnderTest;

    private RequestContext requestContext;

    private File cachedFile;

    @TempDir private File dir;

    @BeforeEach
    void setUp() {
        String prefix = dir.getAbsolutePath().substring(dir.getAbsolutePath().lastIndexOf("/") + 1);
        requestContext =
                new RequestContext(baseUrl, API_KEY, new PlainRequest(), PlainResponse.class);
        createCachedFile();
        unitUnderTest = new FilesystemCachedConnector(prefix);
    }

    @Test
    void get_whenNoCachedFile_thenRequestEndpointAndCreateNewCacheFile() {
        PlainResponse expected = createPlainResponse();
        createCachedFile();
        stubEndpointIsReturningJson();

        PlainResponse actual = unitUnderTest.get(requestContext);

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    private PlainResponse createPlainResponse() {
        return new PlainResponse("message", "reason");
    }

    private void stubEndpointIsReturningJson() {
        stubEndpointIsReturning(JSON, SC_OK);
    }

    private void stubEndpointIsReturning(String json, int statusCode) {
        stubFor(
                get(urlEqualTo(CONTEXT))
                        .withHeader(AUTHORIZATION, equalTo("Bearer " + API_KEY))
                        .willReturn(aResponse().withBody(json).withStatus(statusCode)));
    }

    @Test
    void get_whenNoCachedFileAndEndpointResultIsEmpty_thenRequestDoNotCreateCacheFile() {
        stubEndpointIsReturning("", SC_OK);

        PlainResponse actual = unitUnderTest.get(requestContext);

        assertThat(actual).isNull();
        assertThat(cachedFile).doesNotExist();
    }

    @Test
    void get_whenNoCachedFileAndEndpointResultIsReturningError_thenDoNotCreateCacheFile() {
        stubEndpointIsReturning("", SC_INTERNAL_SERVER_ERROR);

        assertThatExceptionOfType(ConnectorException.class)
                .isThrownBy(() -> unitUnderTest.get(requestContext))
                .withMessage("500: ");
        assertThat(cachedFile).doesNotExist();
    }

    @Test
    void get_whenCachedFileIsEmpty_thenRequestEndpointAndCreateNewCacheFile() throws IOException {
        PlainResponse expected = createPlainResponse();
        writeCachedFile("");
        stubEndpointIsReturningJson();

        PlainResponse actual = unitUnderTest.get(requestContext);

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
        assertThat(cachedFile).content().isEqualTo(JSON);
    }

    private void writeCachedFile(String json) throws IOException {
        write(cachedFile, json, UTF_8);
    }

    private void createCachedFile() {
        cachedFile = new File(dir, baseUrl.hashCode() + ".json");
    }

    @Test
    void get_whenCachedFileTooOld_thenRequestEndpointAndCreateNewCacheFile() throws IOException {
        PlainResponse expected = createPlainResponse();
        writeOldCachedFile();
        stubEndpointIsReturningJson();
        long lastModified = cachedFile.lastModified();

        PlainResponse actual = unitUnderTest.get(requestContext);

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
        assertThat(cachedFile)
                .satisfies(
                        (Consumer<File>)
                                file ->
                                        assertThat(file.lastModified())
                                                .isGreaterThanOrEqualTo(lastModified))
                .content()
                .isEqualTo(JSON);
    }

    private void writeOldCachedFile() throws IOException {
        writeCachedFile(JSON);
        assertThat(
                        cachedFile.setLastModified(
                                currentTimeMillis() - CACHE_TIMEOUT.toMillis() - 1000))
                .isTrue();
    }

    @Test
    void get_whenCachedFileIsValid_thenDoNotRequestEndpointAndDoNotCreateNewCacheFile()
            throws IOException {
        PlainResponse expected = createPlainResponse();
        writeCachedFile(JSON);
        long lastModified = cachedFile.lastModified();

        PlainResponse actual = unitUnderTest.get(requestContext);

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
        assertThat(cachedFile)
                .satisfies(
                        (Consumer<File>)
                                file ->
                                        assertThat(file.lastModified())
                                                .isLessThanOrEqualTo(lastModified))
                .content()
                .isEqualTo(JSON);
    }

    static class PlainRequest extends Request {

        protected PlainRequest() {
            super(false);
        }
    }

    static class PlainResponse extends Response {
        public PlainResponse(String message, String reason) {
            setMessage(message);
            setReason(reason);
        }
    }
}
