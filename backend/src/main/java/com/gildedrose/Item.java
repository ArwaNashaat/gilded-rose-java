package com.gildedrose;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Item")
public class Item {

    @Id
    @GeneratedValue
    @Column(
            name = "id",
            updatable = false
    )
    public int id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    public String name;

    @Column(
            name = "sell_in",
            nullable = false
    )
    public int sellIn;

    @Column(
            name = "quality",
            nullable = false
    )
    public int quality;

    public Item() {
    }

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
