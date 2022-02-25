package com.gildedrose.itemtypes;

import com.gildedrose.strategy.Context;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieTest {

    static final String AGED_BRIE = "Aged Brie";
    Context context = new Context();

    @Test
    void agedBrieIncreaseInQualityTheOlderItGets() {
        Item[] items = new Item[]{new Item(AGED_BRIE, 1, 1)};
        context.setItems(items);
        context.updateQuality();
        assertEquals(2, context.getItems()[0].quality);
    }

    @Test
    void qualityOfAgedBrieIsNeverMoreThan50() {
        Item[] items = new Item[]{new Item(AGED_BRIE, 1, 50)};
        context.setItems(items);
        context.updateQuality();
        assertEquals(50, context.getItems()[0].quality);
    }

    @Test
    void whenSellInEqualsZeroQualityOfAgedBrieIsNeverMoreThan50() {
        Item[] items = new Item[]{new Item(AGED_BRIE, 0, 50)};
        context.setItems(items);
        context.updateQuality();
        assertEquals(50, context.getItems()[0].quality);
    }
}
