package com.gildedrose.gildedrosestrategy;

import com.gildedrose.Item;

public class ConjuredStrategy implements GildedRoseStrategy {

    @Override
    public void updateQuality(Item item) {
        if (item.sellIn > 0)
            item.sellIn--;

        item.quality -= 2;
    }
}
