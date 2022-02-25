package com.gildedrose.database;

import com.gildedrose.Item;
import com.gildedrose.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class InsertItemsTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void insertNormalItemIntoDataBase() {
        Item item = new Item("foo", 5, 5);
        itemRepository.save(item);

        assertEquals(item.toString(), itemRepository.getById(1).toString());
    }
}
