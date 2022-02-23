package com.gildedrose.gildedrosestrategy;

import com.gildedrose.Item;

public class BackstagePassesStrategy implements GildedRoseStrategy {

    @Override
    public void updateQuality(Item item) {

        if (isQualityDroppedToZero(item))
            return;

        doUpdateQualityOf(item);

        item.sellIn--;
        item.quality = Math.min(50, item.quality);
    }

    private void doUpdateQualityOf(Item item) {
        if (isSellInIsLessThan11AndBiggerThan5(item))
            item.quality += 2;
        else if (item.sellIn <= 5)
            item.quality += 3;
        else
            item.quality++;
    }

    private boolean isSellInIsLessThan11AndBiggerThan5(Item item) {
        return item.sellIn < 11 && item.sellIn > 5;
    }

    private boolean isQualityDroppedToZero(Item item) {
        if (qualityDropToZero(item) == 0)
            return true;
        return false;
    }

    private int qualityDropToZero(Item item) {
        if (item.sellIn == 0)
            return item.quality = 0;

        return item.quality;
    }
}
