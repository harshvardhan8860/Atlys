package AutomationAPI;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class HelperClass {

    public void validateStatusCode(Response response, int expectedStatusCode) {

        response.then().assertThat().statusCode(expectedStatusCode);
    }

    public void validateResponseBody(Response response) {

        response.then().assertThat().
                body("name[0]", equalTo("Google Pixel 6 Pro"),
                        "data[0].color", equalTo("Cloudy White"),
                        "data[0].capacity", equalTo("128 GB"));
    }
}
