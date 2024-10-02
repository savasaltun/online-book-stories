package net.azurewebsites.tests;


import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.azurewebsites.base.TestBase;
import net.azurewebsites.dto.Book;
import net.azurewebsites.utility.ApiUtils;
import org.junit.jupiter.api.*;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookApiTests extends TestBase {

    @Order(1)
    @Test
    @Tag("smoke")
    @Tag("book")
    @Tag("getAllBooks")
    @DisplayName("Retrieve all books")
    @Description("Retrieve all books")
    @Severity(SeverityLevel.NORMAL)
    public void testGetAllBooks() {
        Response response = ApiUtils.get("/Books");
        assertEquals(200, response.statusCode());
    }

    @Order(2)
    @Test
    @Tag("smoke")
    @Tag("book")
    @Tag("getSingleBook")
    @DisplayName("Retrieve a book by ID")
    @Description("Retrieve a book by ID")
    @Severity(SeverityLevel.BLOCKER)
    public void testGetBookById() {
        Response response = ApiUtils.get("/Books/1");
        assertEquals(200, response.statusCode());
    }

    @Order(3)
    @Test
    @Tag("smoke")
    @Tag("book")
    @DisplayName("Add a new book")
    @Description("Retrieve a book by ID")
    @Severity(SeverityLevel.CRITICAL)
    public void testAddNewBook() {
        Book newBook = new Book(
                1,
                "Title of the Book 1",
                "Description of the Book",
                300,
                "An excerpt from the book.",
                OffsetDateTime.now()
        );
        Response response = ApiUtils.post("/Books", newBook);
        assertEquals(200, response.statusCode());
        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        String title = jsonPath.getString("title");
        String description = jsonPath.getString("description");
        int pages = jsonPath.getInt("pageCount");
        String excerpt = jsonPath.getString("excerpt");
        assertEquals("Title of the Book 1",title);
        assertEquals("Description of the Book",description);
        assertEquals(300,pages);
        assertEquals("An excerpt from the book.",excerpt);

    }

    @Order(4)
    @Test
    @Tag("smoke")
    @Tag("book")
    @DisplayName("Update an existing book")
    @Description("Update an existing book")
    @Severity(SeverityLevel.BLOCKER)
    public void testUpdateBook() {
        Book updatedBook = new Book(
                1,
                "Updated Title of the Book 1",
                "Updated Description of the Book",
                300,
                "Updated An excerpt from the book.",
                OffsetDateTime.now()
        );
        Response response = ApiUtils.put("/Books/1", updatedBook);
        assertEquals(200, response.statusCode());
        JsonPath jsonPath = response.jsonPath();
        String title = jsonPath.getString("title");
        String description = jsonPath.getString("description");
        int pages = jsonPath.getInt("pageCount");
        String excerpt = jsonPath.getString("excerpt");
        assertEquals("Updated Title of the Book 1",title);
        assertEquals("Updated Description of the Book",description);
        assertEquals(300,pages);
        assertEquals("Updated An excerpt from the book.",excerpt);

    }

    @Order(5)
    @Test
    @Tag("smoke")
    @Tag("book")
    @DisplayName("Delete a book by ID")
    @Description("Delete a book by ID")
    @Severity(SeverityLevel.NORMAL)
    public void testDeleteBook() {
        Response response = ApiUtils.delete("/Books/1");
        assertEquals(200, response.statusCode());
    }
}
