package com.gildedrose.gildedrosestrategy;

import com.gildedrose.Item;

public class NormalItemStrategy implements GildedRoseStrategy {

    @Override
    public void updateQuality(Item item) {
        if (isQualityZeroOrLess(item.quality))
            return;

        if (item.sellIn <= 0)
            item.quality--;

        if (!isQualityZeroOrLess(item.quality))
            decreaseSellInAndQualityByOne(item);
    }

    private void decreaseSellInAndQualityByOne(Item item) {
        item.sellIn--;
        item.quality--;
    }

    private boolean isQualityZeroOrLess(int quality) {
        return quality <= 0;
    }
}
