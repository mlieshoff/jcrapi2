package supercell.api.wrapper.essentials.connector;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import static org.assertj.core.api.Assertions.*;

import static wiremock.org.apache.http.HttpHeaders.AUTHORIZATION;
import static wiremock.org.apache.http.HttpStatus.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import supercell.api.wrapper.essentials.common.*;

import java.net.http.HttpResponse;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class StandardConnectorTest extends ConnectorTestBase {

    private static final String AFTER = "abc";
    private static final String API_KEY = "API_KEY";
    private static final String BEFORE = "xyz";
    private static final String QUERY_NAME1 = "queryName1";
    private static final String QUERY_NAME2 = "queryName2";
    private static final String QUERY_PARAM1 = "query1";
    private static final String QUERY_PARAM2 = "query2";
    private static final String REST_PARAM = "rest";
    private static final String REST_PARAM_ID = "restParam";
    private static final String JSON = "{}";

    private static final int LIMIT = 100;

    private StandardConnector unitUnderTest;

    @BeforeEach
    void setUp() {
        unitUnderTest = new StandardConnector();
    }

    @Test
    void getInitialValue_whenCalled_thenReturnNull() throws Exception {

        String actual = unitUnderTest.getInitialValue(baseUrl);

        assertThat(actual).isNull();
    }

    @Test
    void onJsonReceived_whenCalled_thenReturnNull() {

        assertThatNoException().isThrownBy(() -> unitUnderTest.onJsonReceived(baseUrl, JSON));
    }

    @Test
    void checkResponse_whenCalled_thenReturnUnmodifiedResponse() {

        HttpResponse<String> actual = unitUnderTest.checkResponse(JSON, httpResponse);

        assertThat(actual).isEqualTo(httpResponse);
    }

    @Test
    void get_whenWithoutRestAndQueryParams_thenReturnGetValue() {

        runGet(new PlainResponse(), new PlainRequest(), baseUrl, CONTEXT);
    }

    private void runGet(Response expected, Request request, String toUrl, String stubForUrl) {
        RequestContext requestContext =
                new RequestContext(toUrl, API_KEY, request, expected.getClass());
        stubFor(
                get(urlEqualTo(stubForUrl))
                        .withHeader(AUTHORIZATION, equalTo("Bearer " + API_KEY))
                        .willReturn(aResponse().withBody(JSON).withStatus(SC_OK)));

        Response actual = unitUnderTest.get(requestContext);

        assertResponseIsEqualTo(actual, expected);
    }

    private void assertResponseIsEqualTo(Response actual, Response expected) {
        assertThat(actual)
                .usingRecursiveComparison()
                .withComparatorForFields(
                        (Comparator<Map<String, String>>)
                                (actual1, ignored) -> {
                                    assertThat(actual1).isNotEmpty();
                                    return 0;
                                },
                        "rawResponse.responseHeaders")
                .isEqualTo(expected);
    }

    @Test
    void get_whenWithRestButNoQueryParams_thenReturnGetValue() {

        runGet(
                new ResponseWithRestParameters(),
                new RequestWithRestParameters(),
                baseUrl + "/{restParam}",
                CONTEXT + "/rest");
    }

    @Test
    void get_whenWithoutRestButQueryParams_thenReturnGetValue() {

        runGet(
                new ResponseWithRestAndQueryParameters(),
                new RequestWithRestAndQueryParameters(),
                baseUrl + "/{restParam}/",
                CONTEXT + "/rest/?queryName1=query1&queryName2=query2");
    }

    @Test
    void get_whenWithRestAndQueryParams_thenReturnGetValue() {

        runGet(
                new ResponseWithQueryParameters(),
                new RequestWithQueryParameters(),
                baseUrl + "/",
                CONTEXT + "/?queryName1=query1&queryName2=query2");
    }

    @Test
    void get_whenWithPaginationParams_thenReturnGetValue() {

        runGet(
                new ResponseWithPagination(),
                new RequestWithPagination(),
                baseUrl + "/",
                CONTEXT + "/?limit=100&after=abc&before=xyz");
    }

    @Test
    void get_whenWithNullQueryParam_thenReturnGetValue() {

        runGet(
                new ResponseWithNullQueryParameter(),
                new RequestWithNullQueryParameter(),
                baseUrl,
                CONTEXT);
    }

    @Test
    void get_whenWithStoringRawData_thenReturnGetValue() {

        runGet(
                new PlainResponseWithStoringRawResponse(),
                new PlainRequestWithStoringRawResponse(),
                baseUrl,
                CONTEXT);
    }

    @Test
    void get_whenWithStatusCodeDifferentThan200_thenThrowException() {
        RequestContext requestContext =
                new RequestContext(baseUrl, API_KEY, new PlainRequest(), PlainResponse.class);
        stubFor(
                get(urlEqualTo(CONTEXT))
                        .withHeader(AUTHORIZATION, equalTo("Bearer " + API_KEY))
                        .willReturn(
                                aResponse().withBody(JSON).withStatus(SC_INTERNAL_SERVER_ERROR)));

        assertThatExceptionOfType(ConnectorException.class)
                .isThrownBy(() -> unitUnderTest.get(requestContext))
                .withMessage("500: {}");
    }

    @Test
    void get_whenWithException_thenThrowException() {
        RequestContext requestContext =
                new RequestContext("xxx yyy", API_KEY, new PlainRequest(), PlainResponse.class);

        assertThatExceptionOfType(ConnectorException.class)
                .isThrownBy(() -> unitUnderTest.get(requestContext))
                .withMessage(
                        "java.net.URISyntaxException: Illegal character in path at index 3: xxx"
                                + " yyy");
    }

    static class PlainRequest extends Request {

        protected PlainRequest() {
            super(false);
        }
    }

    static class PlainResponse extends Response {}

    static class RequestWithPagination extends PaginationRequest {

        protected RequestWithPagination() {
            super(LIMIT, AFTER, BEFORE, false);
        }
    }

    static class ResponseWithPagination extends PaginationResponse<String> {}

    static class PlainRequestWithoutStoringRawResponse extends Request {

        protected PlainRequestWithoutStoringRawResponse() {
            super(false);
        }
    }

    static class PlainRequestWithStoringRawResponse extends Request {

        protected PlainRequestWithStoringRawResponse() {
            super(true);
        }
    }

    static class PlainResponseWithStoringRawResponse extends Response {
        protected PlainResponseWithStoringRawResponse() {
            RawResponse rawResponse = new RawResponse();
            rawResponse.setRaw(JSON);
            setRawResponse(rawResponse);
        }
    }

    static class RequestWithRestParameters extends Request {

        protected RequestWithRestParameters() {
            super(new PlainRequestWithoutStoringRawResponse().isStoreRawResponse());
        }

        @Override
        public Map<String, Object> getRestParameters() {
            return Map.of(REST_PARAM_ID, REST_PARAM);
        }
    }

    static class ResponseWithRestParameters extends Response {}

    static class RequestWithQueryParameters extends Request {

        protected RequestWithQueryParameters() {
            super(new PlainRequestWithoutStoringRawResponse().isStoreRawResponse());
        }

        @Override
        public Map<String, Object> getQueryParameters() {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put(QUERY_NAME1, QUERY_PARAM1);
            map.put(QUERY_NAME2, QUERY_PARAM2);
            return map;
        }
    }

    static class ResponseWithQueryParameters extends Response {}

    static class RequestWithNullQueryParameter extends Request {

        protected RequestWithNullQueryParameter() {
            super(new PlainRequestWithoutStoringRawResponse().isStoreRawResponse());
        }

        @Override
        public Map<String, Object> getQueryParameters() {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put(QUERY_NAME1, null);
            return map;
        }
    }

    static class ResponseWithNullQueryParameter extends Response {}

    static class RequestWithRestAndQueryParameters extends Request {

        protected RequestWithRestAndQueryParameters() {
            super(new PlainRequestWithoutStoringRawResponse().isStoreRawResponse());
        }

        @Override
        public Map<String, Object> getRestParameters() {
            return new RequestWithRestParameters().getRestParameters();
        }

        @Override
        public Map<String, Object> getQueryParameters() {
            return new RequestWithQueryParameters().getQueryParameters();
        }
    }

    static class ResponseWithRestAndQueryParameters extends Response {}
}
