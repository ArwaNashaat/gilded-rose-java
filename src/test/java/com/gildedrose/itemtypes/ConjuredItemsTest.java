package com.gildedrose.itemtypes;

import com.gildedrose.Item;
import com.gildedrose.gildedrosestrategy.Context;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredItemsTest {
    final String CONJURED_ITEM = "Conjured";
    Context context = new Context();

    @Test
    void conjuredItemsDecreaseInQualityByTwo() {
        Item[] items = new Item[]{new Item(CONJURED_ITEM, 3, 3)};
        context.setItems(items);
        context.updateQuality();
        assertEquals(1, context.getItems()[0].quality);
    }

}
