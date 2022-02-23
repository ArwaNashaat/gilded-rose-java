package com.gildedrose.gildedrosestrategy;

import com.gildedrose.Item;

public class ConjuredStrategy implements GildedRoseStrategy {

    @Override
    public void updateQuality(Item item) {
        item.quality-=2;
    }
}
