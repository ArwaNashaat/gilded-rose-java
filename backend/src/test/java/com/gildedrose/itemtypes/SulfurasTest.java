package com.gildedrose.itemtypes;

import com.gildedrose.Item;
import com.gildedrose.strategy.Context;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SulfurasTest {

    static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Context context = new Context();

    @Test
    void sulfurasNeverDecreaseInQualityWhenSellInEqualsZero() {
        List<Item> items = createItemListWith(0);

        context.updateQuality(items);
        assertEquals(80, context.getItems().get(0).quality);
    }

    @Test
    void sulfurasNeverDecreaseInQualityWhenSellInIsDoesNotEqualZero() {
        List<Item> items = createItemListWith(1);

        context.updateQuality(items);
        assertEquals(80, context.getItems().get(0).quality);
    }

    private List<Item> createItemListWith(int sellIn) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(SULFURAS, sellIn, 80));
        return items;
    }
}
