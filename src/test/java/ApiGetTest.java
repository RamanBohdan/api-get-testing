import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiGetTest extends AbstractTest {

    @Test
    public void testApiGetTestingStatusCode() {
        String url = "https://restful-booker.herokuapp.com/booking";
        myClient.sendGet(url);

        assertEquals(myClient.getStatusCode(), 200);
    }

    @Test
    public void testApiGetTestingBookingId() throws IOException {
        String url = "https://restful-booker.herokuapp.com/booking";
        String key = "bookingid";
        int value = 168;
        HttpUriRequest request = new HttpGet(url);

        CloseableHttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        String responseBody = EntityUtils.toString(httpResponse.getEntity());

        JSONArray jsonArray = new JSONArray(responseBody);
        List<Integer> bodyList = new ArrayList<>();
        for (Object jsonObject : jsonArray) {
            bodyList.add(((JSONObject) jsonObject).getInt(key));
        }

        assertTrue(bodyList.contains(value));
    }
}
