package com.gildedrose.itemtypes;

import com.gildedrose.strategy.Context;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackstagePassesTest {
    final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    Context context = new Context();
    
    @Test
    void backStagePassesIncreasesInQualityTheOlderItGets() {
        List<Item> items = createItemListWith(16, 5);

        context.updateQuality(items);
        assertEquals(6, context.getItems().get(0).quality);
    }

    @Test
    void backStagePassesQualityIsNeverAbove50() {
        List<Item> items = createItemListWith(5, 49);

        context.updateQuality(items);
        assertEquals(50, context.getItems().get(0).quality);
    }

    @Test
    void backStagePassesIncreasesInQualityBy2WhenSellInIsEquals10() {
        List<Item> items = createItemListWith(10, 5);

        context.updateQuality(items);
        assertEquals(7, context.getItems().get(0).quality);
    }

    @Test
    void backStagePassesIncreasesInQualityBy2WhenSellInIsLessThan10() {
        List<Item> items = createItemListWith(7, 5);

        context.updateQuality(items);
        assertEquals(7, context.getItems().get(0).quality);
    }

    @Test
    void backStagePassesIncreasesInQualityBy2WhenSellInIsLessThan5() {
        List<Item> items = createItemListWith(4, 5);

        context.updateQuality(items);
        assertEquals(8, context.getItems().get(0).quality);
    }

    @Test
    void backStagePassesIncreasesInQualityBy3WhenSellInEquals5() {
        List<Item> items = createItemListWith(5, 5);

        context.updateQuality(items);
        assertEquals(8, context.getItems().get(0).quality);
    }

    @Test
    void backStagePassesIncreasesInQualityBy2WhenSellInEquals6() {
        List<Item> items = createItemListWith(6, 5);

        context.updateQuality(items);
        assertEquals(7, context.getItems().get(0).quality);
    }

    @Test
    void backStagePassesQualityDropsToZeroWhenSellInEquals0() {
        List<Item> items = createItemListWith(0, 5);

        context.updateQuality(items);
        assertEquals(0, context.getItems().get(0).quality);
    }

    @Test
    void backStagePassesSellInDecrease() {
        List<Item> items = createItemListWith(5, 5);

        context.updateQuality(items);
        assertEquals(4, context.getItems().get(0).sellIn);
    }

    private List<Item> createItemListWith(int sellIn, int quality) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(BACKSTAGE_PASSES, sellIn, quality));
        return items;
    }
}
