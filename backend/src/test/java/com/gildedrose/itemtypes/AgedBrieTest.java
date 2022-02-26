package com.gildedrose.itemtypes;

import com.gildedrose.strategy.Context;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieTest {

    static final String AGED_BRIE = "Aged Brie";
    Context context = new Context();

    @Test
    void agedBrieIncreaseInQualityTheOlderItGets() {
        List<Item> items = createItemListWith(1, 1);
        context.updateQuality(items);
        assertEquals(2, context.getItems().get(0).quality);
    }

    @Test
    void qualityOfAgedBrieIsNeverMoreThan50() {
        List<Item> items = createItemListWith(1, 50);
        context.updateQuality(items);
        assertEquals(50, context.getItems().get(0).quality);
    }

    @Test
    void whenSellInEqualsZeroQualityOfAgedBrieIsNeverMoreThan50() {
        List<Item> items = createItemListWith(0, 50);
        context.updateQuality(items);
        assertEquals(50, context.getItems().get(0).quality);
    }


    private List<Item> createItemListWith(int sellIn, int quality) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(AGED_BRIE, sellIn, quality));
        return items;
    }
}
