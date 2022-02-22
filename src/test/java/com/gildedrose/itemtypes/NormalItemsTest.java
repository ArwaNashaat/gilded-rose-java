package com.gildedrose.itemtypes;

import com.gildedrose.GildedRose;
import com.gildedrose.GildedRoseTest;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NormalItemsTest {
    final String NORMAL_ITEM = "foo";
    GildedRoseTest gildedRoseTest = new GildedRoseTest();

    @Test
    void sellInAndQualityValuesDecreaseAfterUpdate() {
        Item[] items = new Item[]{new Item(NORMAL_ITEM, 1, 1)};
        GildedRose gildedRose = gildedRoseTest.updateQualityOf(items);
        assertEquals(0, gildedRose.items[0].sellIn);
        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    void whenSellInEqualsZeroQualityDegradesTwiceAsFast() {
        Item[] items = new Item[]{new Item(NORMAL_ITEM, 0, 6)};
        GildedRose gildedRose = gildedRoseTest.updateQualityOf(items);
        assertEquals(4, gildedRose.items[0].quality);
    }

    @Test
    void qualityOfNormalItemDecreasesQualityIs49() {
        Item[] items = new Item[]{new Item(NORMAL_ITEM, 1, 49)};
        GildedRose gildedRose = gildedRoseTest.updateQualityOf(items);
        assertEquals(48, gildedRose.items[0].quality);
    }

    @Test
    void whenSellInIsNotEqualZeroTheQualityOfAnItemIsNeverNegative() {
        Item[] items = new Item[]{new Item(NORMAL_ITEM, 1, 0)};
        GildedRose gildedRose = gildedRoseTest.updateQualityOf(items);
        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    void whenSellInEqualsZeroTheQualityOfAnItemIsNeverNegative() {
        Item[] items = new Item[]{new Item(NORMAL_ITEM, 0, 1)};
        GildedRose gildedRose = gildedRoseTest.updateQualityOf(items);
        assertEquals(0, gildedRose.items[0].quality);
    }
}
