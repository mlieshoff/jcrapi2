package supercell.api.wrapper.essentials.connector;

import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import java.net.http.HttpResponse;

class ConnectorTestBase {

    static final String API_KEY = "apiKey";
    static final String CONTEXT = "/cache";
    static final String HOST = "localhost";

    static WireMockServer wireMockServer;

    @Mock HttpResponse<String> httpResponse;

    String baseUrl;
    String protocolHostAndPort;

    @BeforeAll
    static void beforeAllWireMock() {
        WireMockConfiguration wireMockConfiguration = new WireMockConfiguration().dynamicPort();
        wireMockServer = new WireMockServer(wireMockConfiguration);
        wireMockServer.start();
    }

    @AfterEach
    void tearDownWireMock() {
        wireMockServer.resetAll();
    }

    @BeforeEach
    void setUpWireMock() {
        configureFor(HOST, wireMockServer.port());
        protocolHostAndPort = "http://" + HOST + ":" + wireMockServer.port();
        baseUrl = protocolHostAndPort + CONTEXT;
    }
}
