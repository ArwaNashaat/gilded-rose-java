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

    Item[] items;

    @BeforeEach
    public void setUp() {
        RestAssured.port = 8080;
        items = createItemsArray();
    }

    @Test
    public void ItemIsAddedTest() {
        Item normalItem = new Item("Aged Brie", 5, 8);

        addItem(normalItem);

        assertThatItemInTheDatabaseEquals(normalItem);
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
        hitAddItemRequest(items);

        Response response = getAllItemsResponse();

        List<Item> actualItems = getResponseBodyAsItemList(response);
        List<Item> expectedItems = getExpectedItemAsList(items);

        assertEquals(expectedItems.toString(), actualItems.toString());
    }

    private Response getAllItemsResponse() {
        return given().
                when().
                get("/Item/getAllItems").andReturn();
    }

    private void hitAddItemRequest(Item[] items) {
        for (int i = 0; i < items.length; i++)
            addItem(items[i]);
    }

    private List<Item> getExpectedItemAsList(Item[] items) {
        List<Item> itemList = new ArrayList<>();
        for (int i = 0; i < items.length; i++)
            itemList.add(items[i]);
        return itemList;
    }

    private List<Item> getResponseBodyAsItemList(Response response) {
        Genson genson = new Genson();
        return genson.deserialize(response.body().asByteArray(), new GenericType<List<Item>>() {
        });
    }

    @Test
    public void getAgedBrieItemsTest() {
        hitAddItemRequest(items);

        Response response = getAgedBrieItemsResponse();

        List<Item> actualItems = getResponseBodyAsItemList(response);
        List<Item> expectedItems = getExpectedAgedBrieItemAsList(items);
        assertEquals(expectedItems.toString(), actualItems.toString());
    }

    private Response getAgedBrieItemsResponse() {
        return given().
                when().
                get("/Item/getAgedBrieItems").andReturn();
    }

    private List<Item> getExpectedAgedBrieItemAsList(Item[] items) {
        List<Item> itemList = new ArrayList<>();
        for (int i = 0; i < items.length; i++)
            if (items[i].name.contains("Aged Brie"))
                itemList.add(items[i]);
        return itemList;
    }

    private Item[] createItemsArray() {
        return new Item[]{
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Conjured Mana Cake", 3, 6)};
    }
}
