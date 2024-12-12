package AutomationAPI;

import org.testng.annotations.Test;

public class APITest extends APIBase{

    HelperClass helper = new HelperClass();

    // Verify status code for valid path
    @Test
    public void getRequestToValidateStatusCode() {

        helper.validateStatusCode(sendGetRequest("objects"), 200);

    }

    // Verify status code for invalid path
    @Test
    public void getRequestToValidateInvalidPath() {

        helper.validateStatusCode(sendGetRequest("randomvalue"), 404);

    }

    // Verify response body
    @Test
    public void getRequestToValidateResponseBody() {

        helper.validateResponseBody(sendGetRequest("objects"));

    }

}
