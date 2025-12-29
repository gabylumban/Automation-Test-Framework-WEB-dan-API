package tests;

import config.BaseTest;
import requests.UserRequest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserApiTest extends BaseTest {

    @Test
    void getUsers_validPage() {
        UserRequest.getUsers(TestDataUtil.VALID_PAGE)
                .then()
                .statusCode(200)
                .body("data", not(empty()))
                .log().all();
    }

    @Test
    void getUserById_invalidId() {
        UserRequest.getUserById(TestDataUtil.INVALID_USER_ID)
                .then()
                .statusCode(404)
                .body(equalTo("{}"))
                .log().all();
    }

    @Test
    void getUsers_invalidPage() {
        UserRequest.getUsers(TestDataUtil.INVALID_PAGE)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void getUsers_boundaryPageZero() {
        UserRequest.getUsers(TestDataUtil.BOUNDARY_PAGE)
                .then()
                .statusCode(200)
                .body("page", equalTo(1))
                .log().all();
    }
}
