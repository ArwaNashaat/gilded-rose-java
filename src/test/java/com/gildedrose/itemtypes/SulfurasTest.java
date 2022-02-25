package com.gildedrose.itemtypes;

import com.gildedrose.Item;
import com.gildedrose.strategy.Context;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SulfurasTest {

    static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Context context = new Context();

    @Test
    void sulfurasNeverDecreaseInQualityWhenSellInEqualsZero() {
        Item[] items = new Item[]{new Item(SULFURAS, 0, 80)};
        context.setItems(items);
        context.updateQuality();
        assertEquals(80, context.getItems()[0].quality);
    }

    @Test
    void sulfurasNeverDecreaseInQualityWhenSellInIsDoesNotEqualZero() {
        Item[] items = new Item[]{new Item(SULFURAS, 1, 80)};
        context.setItems(items);
        context.updateQuality();
        assertEquals(80, context.getItems()[0].quality);
    }
}
