package requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserRequest {

    public Response getUser() {
        return given()
                .when()
                .get("/users/1");
    }
}
