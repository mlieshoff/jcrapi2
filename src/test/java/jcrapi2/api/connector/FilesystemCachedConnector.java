package jcrapi2.api.connector;

import static org.apache.http.HttpStatus.SC_OK;

import jcrapi2.connector.StandardConnector;

import lombok.extern.slf4j.Slf4j;

import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.Duration;

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
        //        String hash = String.valueOf(url.hashCode());
        //        File file = new File(DIR, hash + ".json");
        //        boolean makeRequest;
        //        if (file.exists()) {
        //            log.info("found cached file {} for {}", file.getAbsolutePath(), url);
        //            long millis = file.lastModified();
        //            long validTo = millis + CACHE_TIMEOUT.toMillis();
        //            Date now = new Date();
        //            json = Files.readString(file.toPath());
        //            makeRequest = json == null || json.isEmpty() || now.getTime() > validTo;
        //            if (makeRequest) {
        //                log.info(
        //                        "cached file {} with size {} at {} for {} was invalid at {}",
        //                        file.getAbsolutePath(),
        //                        json != null ? json.length() : 0,
        //                        new Date(validTo),
        //                        url,
        //                        now);
        //                json = null;
        //            } else {
        //                log.info("use cached file {} for {}", file.getAbsolutePath(), url);
        //            }
        //        } else {
        //            log.info("no cached file {} found for {}", file.getAbsolutePath(), url);
        //        }
        return json;
    }

    @Override
    protected HttpResponse checkResponse(String json, HttpResponse response)
            throws UnsupportedEncodingException {
        HttpResponse cachedHttpResponse =
                new BasicHttpResponse(
                        new BasicStatusLine(new ProtocolVersion("https", 1, 2), SC_OK, "cached"));
        cachedHttpResponse.setEntity(new StringEntity(json));
        return cachedHttpResponse;
    }

    @Override
    protected void onJsonReceived(String url, String json) throws IOException {
        //        if (json == null || json.isEmpty()) {
        //            log.info("received empty JSON for {}, skip saving.", url);
        //            return;
        //        }
        //        String hash = String.valueOf(url.hashCode());
        //        File file = new File(DIR, hash + ".json");
        //        Files.writeString(file.toPath(), json);
        //        log.info("save file {} for cache of {}", file.getAbsolutePath(), url);
    }
}
