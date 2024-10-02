package net.azurewebsites.base;

import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    private static final Dotenv dotenv = Dotenv.load();
    @BeforeAll
    public static void setup() {

        RestAssured.baseURI = dotenv.get("BASE_URL");
    }
}
