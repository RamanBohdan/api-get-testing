import api.client.MyClient;
import org.junit.jupiter.api.BeforeEach;

public class AbstractTest {

    MyClient myClient;

    @BeforeEach
    public void getClient() {
        myClient = new MyClient();
    }
}
