package com.gildedrose.strategy;

import com.gildedrose.Item;

public class Context {
    GildedRoseStrategy gildedRoseStrategy;
    Item[] items;

    public void setItems(Item[] items) {
        this.items = items;
    }

    public Item[] getItems() {
        return items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            setStrategyFor(items[i]);
            gildedRoseStrategy.updateQuality(items[i]);
        }
    }

    private void setStrategyFor(Item item) {
        if (item.name.contains("Aged Brie"))
            this.gildedRoseStrategy = new AgedBrieStrategy();

        else if (item.name.contains("Backstage passes"))
            this.gildedRoseStrategy = new BackstagePassesStrategy();

        else if (item.name.contains("Sulfuras"))
            this.gildedRoseStrategy = new SulfurasStrategy();

        else if(item.name.contains("Conjured"))
            this.gildedRoseStrategy = new ConjuredStrategy();
        else
            this.gildedRoseStrategy = new NormalItemStrategy();
    }
}
