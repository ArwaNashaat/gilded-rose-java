package com.gildedrose.strategy;

import com.gildedrose.Item;

public class SulfurasStrategy implements GildedRoseStrategy {

    @Override
    public void updateQuality(Item item) {
        if (item.sellIn > 0)
            item.sellIn--;

        item.quality = 80;
    }
}
