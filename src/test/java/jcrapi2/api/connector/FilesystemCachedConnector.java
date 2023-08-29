package jcrapi2.api.connector;

import jcrapi2.connector.StandardConnector;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Date;
import java.util.Optional;

import javax.net.ssl.SSLSession;

@Slf4j
public class FilesystemCachedConnector extends StandardConnector {

    public static final Duration CACHE_TIMEOUT = Duration.ofMinutes(5);

    private static final File DIR = new File(System.getProperty("java.io.tmpdir") + "/jcrapi2");

    static {
        if (!DIR.mkdirs()) {
            log.warn("couldn't create tmp dir {}", DIR.getAbsolutePath());
        }
    }

    @Override
    protected String getInitialValue(String url) throws IOException {
        String json = null;
        String hash = String.valueOf(url.hashCode());
        File file = new File(DIR, hash + ".json");
        boolean makeRequest;
        if (file.exists()) {
            log.info("found cached file {} for {}", file.getAbsolutePath(), url);
            long millis = file.lastModified();
            long validTo = millis + CACHE_TIMEOUT.toMillis();
            Date now = new Date();
            json = Files.readString(file.toPath());
            makeRequest = json == null || json.isEmpty() || now.getTime() > validTo;
            if (makeRequest) {
                log.info(
                        "cached file {} with size {} at {} for {} was invalid at {}",
                        file.getAbsolutePath(),
                        json != null ? json.length() : 0,
                        new Date(validTo),
                        url,
                        now);
                json = null;
            } else {
                log.info("use cached file {} for {}", file.getAbsolutePath(), url);
            }
        } else {
            log.info("no cached file {} found for {}", file.getAbsolutePath(), url);
        }
        return json;
    }

    @Override
    protected HttpResponse<String> checkResponse(String json, HttpResponse<String> response) {
        return new CachedHttpResponse<>(200, json);
    }

    @Override
    protected void onJsonReceived(String url, String json) throws IOException {
        if (json == null || json.isEmpty()) {
            log.info("received empty JSON for {}, skip saving.", url);
            return;
        }
        String hash = String.valueOf(url.hashCode());
        File file = new File(DIR, hash + ".json");
        Files.writeString(file.toPath(), json);
        log.info("save file {} for cache of {}", file.getAbsolutePath(), url);
    }

    record CachedHttpResponse<T>(int statusCode, T body) implements HttpResponse<T> {

        @Override
        public HttpRequest request() {
            return null;
        }

        @Override
        public Optional<HttpResponse<T>> previousResponse() {
            return Optional.empty();
        }

        @Override
        public HttpHeaders headers() {
            return null;
        }

        @Override
        public Optional<SSLSession> sslSession() {
            return Optional.empty();
        }

        @Override
        public URI uri() {
            return null;
        }

        @Override
        public HttpClient.Version version() {
            return HttpClient.Version.HTTP_1_1;
        }
    }
}
