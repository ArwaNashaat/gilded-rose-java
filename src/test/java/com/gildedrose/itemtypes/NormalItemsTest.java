package com.gildedrose.itemtypes;

import com.gildedrose.gildedrosestrategy.Context;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NormalItemsTest {
    final String NORMAL_ITEM = "foo";
    Context context = new Context();
    
    @Test
    void sellInAndQualityValuesDecreaseAfterUpdate() {
        Item[] items = new Item[]{new Item(NORMAL_ITEM, 1, 1)};
        context.setItems(items);
        context.updateQuality();
        assertEquals(0, context.getItems()[0].sellIn);
        assertEquals(0, context.getItems()[0].quality);
    }

    @Test
    void whenSellInEqualsZeroQualityDegradesTwiceAsFast() {
        Item[] items = new Item[]{new Item(NORMAL_ITEM, 0, 6)};
        context.setItems(items);
        context.updateQuality();
        assertEquals(4, context.getItems()[0].quality);
    }

    @Test
    void qualityOfNormalItemDecreasesQualityIs49() {
        Item[] items = new Item[]{new Item(NORMAL_ITEM, 1, 49)};
        context.setItems(items);
        context.updateQuality();
        assertEquals(48, context.getItems()[0].quality);
    }

    @Test
    void whenSellInIsNotEqualZeroTheQualityOfAnItemIsNeverNegative() {
        Item[] items = new Item[]{new Item(NORMAL_ITEM, 1, 0)};
        context.setItems(items);
        context.updateQuality();
        assertEquals(0, context.getItems()[0].quality);
    }

    @Test
    void whenSellInEqualsZeroTheQualityOfAnItemIsNeverNegative() {
        Item[] items = new Item[]{new Item(NORMAL_ITEM, 0, 1)};
        context.setItems(items);
        context.updateQuality();
        assertEquals(0, context.getItems()[0].quality);
    }

    @Test
    void qualityOfNormalItemIsNeverMoreThan50() {
        Item[] items = new Item[]{new Item(NORMAL_ITEM, 1, 51)};
        context.setItems(items);
        context.updateQuality();
        assertEquals(50, context.getItems()[0].quality);
    }
}
