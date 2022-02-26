package com.gildedrose.restservice;

import com.gildedrose.Item;
import com.owlike.genson.GenericType;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.owlike.genson.Genson;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
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

    @Test
    public void getAllItemsTest() {
        Item normalItem = new Item("+5 Dexterity Vest", 10, 20);
        Item agedBrieItem = new Item("Aged Brie", 2, 0);

        hitAddItemRequest(normalItem, agedBrieItem);

        Response response = getAllItemsResponse();

        List<Item> actualItems = getResponseBodyAsItemList(response);
        List<Item> expectedItems = getExpectedItemAsList(normalItem, agedBrieItem);

        assertEquals(expectedItems.toString(), actualItems.toString());
    }

    private Response getAllItemsResponse() {
        return given().
                when().
                get("/Item/getAllItems").andReturn();
    }

    private void hitAddItemRequest(Item normalItem, Item agedBrieItem) {
        addItem(normalItem);
        addItem(agedBrieItem);
    }

    private List<Item> getExpectedItemAsList(Item normalItem, Item agedBrieItem) {
        List<Item> items = new ArrayList<>();
        items.add(normalItem);
        items.add(agedBrieItem);
        return items;
    }

    private List<Item> getResponseBodyAsItemList(Response response) {
        Genson genson = new Genson();
        return genson.deserialize(response.body().asByteArray(), new GenericType<List<Item>>(){});
    }

}
