import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiGetTest {

    private final static String URL = "https://restful-booker.herokuapp.com/booking";
    private final static String key = "bookingid";
    private final static String value = "168";

    @Test
    public void testApiGetTestingStatusCode() throws IOException {
        HttpGet request = new HttpGet(URL);
        CloseableHttpResponse response = HttpClientBuilder.create().build().execute(request);

        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test
    public void testApiGetTestingBookingId() throws IOException, ParseException {
        HttpGet request = new HttpGet(URL);
        CloseableHttpResponse response = HttpClientBuilder.create().build().execute(request);
        String responseText = EntityUtils.toString(response.getEntity());

        JSONParser jsonParse = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParse.parse(responseText);
        JSONArray bookingId = (JSONArray) jsonObject.get("bookingid");

    }
}
