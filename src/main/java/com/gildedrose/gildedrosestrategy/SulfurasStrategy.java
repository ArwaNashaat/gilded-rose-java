package com.gildedrose.gildedrosestrategy;

import com.gildedrose.Item;

public class SulfurasStrategy implements GildedRoseStrategy {

    @Override
    public void updateQuality(Item item) {
        item.quality = 80;
    }
}
