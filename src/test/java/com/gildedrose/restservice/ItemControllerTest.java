package com.gildedrose.restservice;

import com.gildedrose.Item;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ItemControllerTest {

    @BeforeEach
    public void setUp() {
        RestAssured.port = 8080;
    }

    @Test
    public void ItemIsAddedTest() {
        Item item = new Item("Aged Brie", 5, 8);

        addItem(item);

        assertThatItemInTheDatabaseEquals(item);
    }

    private void addItem(Item item) {
        given().
                body(item).
                and().
                header("Content-Type", "application/json").
                when().
                post("/Item/add").
                then().
                statusCode(200);
    }

    private void assertThatItemInTheDatabaseEquals(Item item) {
        given().
                when().
                get("/Item/get/" + 1).
                then().
                statusCode(200).
                and().
                body(equalTo("{" + item + "}"));
    }
}
