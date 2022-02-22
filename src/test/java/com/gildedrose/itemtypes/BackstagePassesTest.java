package com.gildedrose.itemtypes;

import com.gildedrose.GildedRose;
import com.gildedrose.GildedRoseTest;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackstagePassesTest {
    final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    GildedRoseTest gildedRoseTest = new GildedRoseTest();

    @Test
    void backStagePassesIncreasesInQualityTheOlderItGets() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 16, 5)};
        GildedRose gildedRose = gildedRoseTest.updateQualityOf(items);
        assertEquals(6, gildedRose.items[0].quality);
    }

    @Test
    void backStagePassesIncreasesInQualityBy2WhenSellInIsEquals10() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 10, 5)};
        GildedRose app = gildedRoseTest.updateQualityOf(items);
        assertEquals(7, app.items[0].quality);
    }

    @Test
    void backStagePassesIncreasesInQualityBy2WhenSellInIsLessThan10() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 7, 5)};
        GildedRose app = gildedRoseTest.updateQualityOf(items);
        assertEquals(7, app.items[0].quality);
    }

    @Test
    void backStagePassesIncreasesInQualityBy2WhenSellInIsLessThan5() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 4, 5)};
        GildedRose app = gildedRoseTest.updateQualityOf(items);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void backStagePassesIncreasesInQualityBy2WhenSellInEquals5() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 5, 5)};
        GildedRose app = gildedRoseTest.updateQualityOf(items);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void backStagePassesIncreasesInQualityBy2WhenSellInEquals6() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 6, 5)};
        GildedRose app = gildedRoseTest.updateQualityOf(items);
        assertEquals(7, app.items[0].quality);
    }

    @Test
    void backStagePassesQualityDropsToZeroWhenSellInEquals0() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 0, 5)};
        GildedRose app = gildedRoseTest.updateQualityOf(items);
        assertEquals(0, app.items[0].quality);
    }
}
