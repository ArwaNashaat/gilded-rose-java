package com.gildedrose.itemtypes;

import com.gildedrose.strategy.Context;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NormalItemsTest {
    final String NORMAL_ITEM = "foo";
    Context context = new Context();
    
    @Test
    void sellInAndQualityValuesDecreaseAfterUpdate() {
        List<Item> items = createItemListWith(1, 1);

        context.updateQuality(items);
        assertEquals(0, context.getItems().get(0).sellIn);
        assertEquals(0, context.getItems().get(0).quality);
    }

    @Test
    void whenSellInEqualsZeroQualityDegradesTwiceAsFast() {
        List<Item> items = createItemListWith(0, 6);

        context.updateQuality(items);
        assertEquals(4, context.getItems().get(0).quality);
    }

    @Test
    void qualityOfNormalItemDecreasesQualityIs49() {
        List<Item> items = createItemListWith(1, 49);

        context.updateQuality(items);
        assertEquals(48, context.getItems().get(0).quality);
    }

    @Test
    void whenSellInIsNotEqualZeroTheQualityOfAnItemIsNeverNegative() {
        List<Item> items = createItemListWith(1, 0);

        context.updateQuality(items);
        assertEquals(0, context.getItems().get(0).quality);
    }

    @Test
    void whenSellInEqualsZeroTheQualityOfAnItemIsNeverNegative() {
        List<Item> items = createItemListWith(0, 1);

        context.updateQuality(items);
        assertEquals(0, context.getItems().get(0).quality);
    }

    @Test
    void qualityOfNormalItemIsNeverMoreThan50() {
        List<Item> items = createItemListWith(1, 51);

        context.updateQuality(items);
        assertEquals(50, context.getItems().get(0).quality);
    }

    private List<Item> createItemListWith(int sellIn, int quality) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(NORMAL_ITEM, sellIn, quality));
        return items;
    }
}
