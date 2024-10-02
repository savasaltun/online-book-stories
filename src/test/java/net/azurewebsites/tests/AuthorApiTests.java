package net.azurewebsites.tests;


import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import net.azurewebsites.base.TestBase;
import net.azurewebsites.dto.Author;
import net.azurewebsites.utility.ApiUtils;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuthorApiTests extends TestBase {

    @Order(1)
    @Test
    @Tag("smoke")
    @Tag("author")
    @Tag("getAllAuthors")
    @DisplayName("Retrieve all authors")
    @Description("This endpoint retrieves all authors")
    @Severity(SeverityLevel.BLOCKER)
    public void testGetAllAuthors() {
        Response response = ApiUtils.get("/Authors");
        response.prettyPrint();
        assertEquals(200, response.statusCode());
    }

    @Order(2)
    @Test
    @Tag("smoke")
    @Tag("author")
    @Tag("getSingleAuthor")
    @DisplayName("Retrieve an author by ID")
    @Description("Retrieve an author by ID")
    @Severity(SeverityLevel.BLOCKER)
    public void testGetAuthorById() {
        Response response = ApiUtils.get("/Authors/1");
        assertEquals(200, response.statusCode());
    }

    @Order(3)
    @Test
    @Tag("smoke")
    @Tag("author")
    @DisplayName("Add a new author")
    @Description("Add a new author")
    @Severity(SeverityLevel.CRITICAL)
    public void testAddNewAuthor() {
        Author newAuthor = new Author(
                1,
                1,
                "John",
                "Doe"
        );
        Response response = ApiUtils.post("/Authors", newAuthor);
        assertEquals(200, response.statusCode());
        String firstName = response.jsonPath().getString("firstName");
        String lastName = response.jsonPath().getString("lastName");
        assertEquals(firstName,"John");
        assertEquals(lastName,"Doe");
    }




    @Order(4)
    @Test
    @Tag("smoke")
    @Tag("author")
    @DisplayName("Update an existing author")
    @Description("Update an existing author")
    @Severity(SeverityLevel.NORMAL)
    public void testUpdateAuthor() {
        Author updatedAuthor = new Author(
                1,
                1,
                "Updated John",
                "Updated Doe"
        );
        Response response = ApiUtils.put("/Authors/1", updatedAuthor);

        assertEquals(200, response.statusCode());
        String firstName = response.jsonPath().getString("firstName");
        String lastName = response.jsonPath().getString("lastName");
        assertEquals(firstName,"Updated John");
        assertEquals(lastName,"Updated Doe");
    }

    @Order(5)
    @Test
    @Tag("smoke")
    @Tag("author")
    @DisplayName("Delete an author by ID")
    @Description("Delete an author by ID")
    @Severity(SeverityLevel.NORMAL)
    public void testDeleteAuthor() {
        Response response = ApiUtils.delete("/Authors/1");
        assertEquals(200, response.statusCode());
    }

}
