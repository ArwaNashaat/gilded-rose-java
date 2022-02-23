package com.gildedrose.gildedrosestrategy;

import com.gildedrose.Item;

public class AgedBrieStrategy implements GildedRoseStrategy {

    @Override
    public void updateQuality(Item item) {
        if (item.sellIn == 0)
            return;

        item.sellIn--;
        item.quality++;

        item.quality = Math.min(50, item.quality);

    }
}
