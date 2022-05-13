package api.client;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class MyClient {
    private static final Logger logger = LogManager.getLogger();

    HttpResponse response;
    String body;
    int statusCode;
    CloseableHttpClient httpClient;

    public MyClient() {
        httpClient = HttpClientBuilder.create().build();
    }

    public void sendGet(String URL) {
        try {
            response = httpClient.execute(new HttpGet(URL));
        } catch (IOException e) {
            logger.warn(e.getMessage());
        }
    }

    public int getStatusCode() {
        statusCode = response.getStatusLine().getStatusCode();
        logger.info(statusCode);
        return statusCode;
    }

    public String getBody() {
        try {
            body = EntityUtils.toString(response.getEntity());
            logger.info(body);
        } catch (IOException e) {
            logger.warn(e.getMessage());
        }
        return body;
    }
}
