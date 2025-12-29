package stepdef;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import requests.UserRequest;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserApiStepDef {

    Response response;

    @Given("user requests list users on page {int}")
    public void user_requests_list_users_on_page(Integer page) {
        response = UserRequest.getUsers(page);
    }

    @Then("response status code should be {int}")
    public void response_status_code_should_be(Integer statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("response body should contain users")
    public void response_body_should_contain_users() {
        response.then().body("data", not(empty()));
    }
}
