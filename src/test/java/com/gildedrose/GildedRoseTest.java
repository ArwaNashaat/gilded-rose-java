package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {
    public GildedRose updateQualityOf(Item[] items) {
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        return gildedRose;
    }

    @Test
    void sulfurasNeverDecreaseInQualityWhenSellInEqualsZero() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        GildedRose gildedRose = updateQualityOf(items);
        assertEquals(80, gildedRose.items[0].quality);
    }

    @Test
    void sulfurasNeverDecreaseInQualityWhenSellInIsDoesNotEqualZero() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 1, 80)};
        GildedRose gildedRose = updateQualityOf(items);
        assertEquals(80, gildedRose.items[0].quality);
    }
}
