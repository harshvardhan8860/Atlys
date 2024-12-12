package AutomationAPI;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class APIBase {

    public static final String apiBaseUrl = "https://api.restful-api.dev/";

    // Helper method to make the Get API call
    public Response sendGetRequest(String endpoint) {

        return given().
                // headers can be added here
                    pathParams("mp", endpoint).
                when().
                    get(apiBaseUrl + "{mp}").
                then().
                    log().ifError(). // Log response only if error
                    log().ifValidationFails(). // Log response only if there is failure in validation
                    extract().response();
    }
}
