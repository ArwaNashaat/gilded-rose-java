package com.gildedrose.strategy;

import com.gildedrose.Item;

import java.util.List;

public class Context {
    GildedRoseStrategy gildedRoseStrategy;
    List<Item> items;

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void updateQuality(List<Item> items) {
        setItems(items);
        for (int i = 0; i < this.items.size(); i++) {
            setStrategyFor(this.items.get(i));
            gildedRoseStrategy.updateQuality(this.items.get(i));
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
