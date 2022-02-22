package com.gildedrose;

public class GildedRose {
    public Item[] items;
    final int UPDATE_BY_ONE = 1;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    decreaseQualityOfAllItemsExceptForSulfuras(i);
                }
            } else {

                increaseQualityWhenQualityIsLessThan50By(i, UPDATE_BY_ONE);

                if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (items[i].sellIn < 11) {
                        increaseQualityWhenQualityIsLessThan50By(i, UPDATE_BY_ONE);
                    }

                    if (items[i].sellIn < 6) {
                        increaseQualityWhenQualityIsLessThan50By(i, UPDATE_BY_ONE);
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - UPDATE_BY_ONE;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert") && items[i].quality > 0) {

                        decreaseQualityOfAllItemsExceptForSulfuras(i);

                    } else {
                        decreaseQualityBy(i, items[i].quality);
                    }
                } else {
                    increaseQualityWhenQualityIsLessThan50By(i, UPDATE_BY_ONE);
                }
            }
        }
    }

    private void decreaseQualityOfAllItemsExceptForSulfuras(int i) {
        if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
            decreaseQualityBy(i, UPDATE_BY_ONE);
        }
    }

    private void decreaseQualityBy(int i, int decreaseValue) {
        items[i].quality = items[i].quality - decreaseValue;
    }

    private void increaseQualityWhenQualityIsLessThan50By(int i, int increaseValue) {
        if (items[i].quality < 50) {
            items[i].quality = items[i].quality + increaseValue;
        }
    }
}