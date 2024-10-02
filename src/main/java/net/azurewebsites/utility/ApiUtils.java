package net.azurewebsites.utility;

import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiUtils {
    private static final Dotenv dotenv = Dotenv.load();
    private static final String BASE_URL = dotenv.get("BASE_URL");



    public static Response get(String endpoint) {
        return RestAssured.get(BASE_URL + endpoint);
    }


    public static Response post(String endpoint, Object body) {
        return RestAssured.given()
                .contentType("application/json")
                .body(body)
                .post(BASE_URL + endpoint);
    }


    public static Response put(String endpoint, Object body) {
        return RestAssured.given()
                .contentType("application/json")
                .body(body)
                .put(BASE_URL + endpoint);
    }

    public static Response delete(String endpoint) {
        return RestAssured.delete(BASE_URL + endpoint);
    }
}
