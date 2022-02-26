package com.gildedrose.itemtypes;

import com.gildedrose.Item;
import com.gildedrose.strategy.Context;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredItemsTest {
    final String CONJURED_ITEM = "Conjured";
    Context context = new Context();

    @Test
    void conjuredItemsDecreaseInQualityByTwo() {
        List<Item> items = createItemListWith(3, 3);
        context.updateQuality(items);
        assertEquals(1, context.getItems().get(0).quality);
    }

    @Test
    void sellInDecreases() {
        List<Item> items = createItemListWith(3, 3);
        context.updateQuality(items);
        assertEquals(2, context.getItems().get(0).sellIn);
    }

    @Test
    void sellInisNeverNegative() {
        List<Item> items = createItemListWith(0,3);

        context.updateQuality(items);
        assertEquals(0, context.getItems().get(0).sellIn);
    }

    private List<Item> createItemListWith(int sellIn, int quality) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(CONJURED_ITEM, sellIn, quality));
        return items;
    }
}
