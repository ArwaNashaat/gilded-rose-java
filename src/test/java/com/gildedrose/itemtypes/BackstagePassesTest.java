package com.gildedrose.itemtypes;

import com.gildedrose.strategy.Context;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackstagePassesTest {
    final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    Context context = new Context();
    
    @Test
    void backStagePassesIncreasesInQualityTheOlderItGets() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 16, 5)};
        context.setItems(items);
        context.updateQuality();
        assertEquals(6, context.getItems()[0].quality);
    }

    @Test
    void backStagePassesQualityIsNeverAbove50() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 5, 49)};
        context.setItems(items);
        context.updateQuality();
        assertEquals(50, context.getItems()[0].quality);
    }

    @Test
    void backStagePassesIncreasesInQualityBy2WhenSellInIsEquals10() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 10, 5)};
        context.setItems(items);
        context.updateQuality();
        assertEquals(7, context.getItems()[0].quality);
    }

    @Test
    void backStagePassesIncreasesInQualityBy2WhenSellInIsLessThan10() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 7, 5)};
        context.setItems(items);
        context.updateQuality();
        assertEquals(7, context.getItems()[0].quality);
    }

    @Test
    void backStagePassesIncreasesInQualityBy2WhenSellInIsLessThan5() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 4, 5)};
        context.setItems(items);
        context.updateQuality();
        assertEquals(8, context.getItems()[0].quality);
    }

    @Test
    void backStagePassesIncreasesInQualityBy3WhenSellInEquals5() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 5, 5)};
        context.setItems(items);
        context.updateQuality();
        assertEquals(8, context.getItems()[0].quality);
    }

    @Test
    void backStagePassesIncreasesInQualityBy2WhenSellInEquals6() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 6, 5)};
        context.setItems(items);
        context.updateQuality();
        assertEquals(7, context.getItems()[0].quality);
    }

    @Test
    void backStagePassesQualityDropsToZeroWhenSellInEquals0() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 0, 5)};
        context.setItems(items);
        context.updateQuality();
        assertEquals(0, context.getItems()[0].quality);
    }

    @Test
    void backStagePassesSellInDecrease() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 5, 5)};
        context.setItems(items);
        context.updateQuality();
        assertEquals(4, context.getItems()[0].sellIn);
    }
}
