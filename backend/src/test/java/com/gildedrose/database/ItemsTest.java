package com.gildedrose.database;

import com.gildedrose.Item;
import com.gildedrose.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ItemsTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void insertNormalItemIntoDataBase() {
        Item item = new Item("foo", 5, 5);
        itemRepository.save(item);

        assertEquals(item.toString(), itemRepository.getById(1).toString());
    }

    @Test
    public void getAllAgedBrieItemsTest() {
        Item[] items = createItemsArray();

        insertItemsToTheDataBase(items);

        List<Item> agedBrieItems = getAgedBrieFromItems(items);

        assertEquals(agedBrieItems.toString(), itemRepository.getAgedBrieItems().toString());
    }

    private List<Item> getAgedBrieFromItems(Item[] items) {
        List<Item> agedBrieItems = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            if(items[i].name.contains("Aged Brie"))
                agedBrieItems.add(items[i]);
        }
        return agedBrieItems;
    }

    private void insertItemsToTheDataBase(Item[] items) {
        List<Item> itemsList = copyItemToList(items);

        itemRepository.saveAll(itemsList);
    }

    private List<Item> copyItemToList(Item[] items) {
        List<Item> itemsList = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            itemsList.add(items[i]);
        }
        return itemsList;
    }

    private Item[] createItemsArray() {
        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Conjured Mana Cake", 3, 6)};
        return items;
    }
}
