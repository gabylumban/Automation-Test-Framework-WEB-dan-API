package config;

import io.restassured.RestAssured;
import org.junit.Before;

public class BaseTest {

    @Before
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
}
