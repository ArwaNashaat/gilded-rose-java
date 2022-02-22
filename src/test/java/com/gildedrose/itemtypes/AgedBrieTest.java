package com.gildedrose.itemtypes;

import com.gildedrose.GildedRose;
import com.gildedrose.GildedRoseTest;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieTest {

    public static final String AGED_BRIE = "Aged Brie";
    GildedRoseTest gildedRoseTest = new GildedRoseTest();

    @Test
    void agedBrieIncreaseInQualityTheOlderItGets() {
        Item[] items = new Item[]{new Item(AGED_BRIE, 1, 1)};
        GildedRose gildedRose = gildedRoseTest.updateQualityOf(items);
        assertEquals(2, gildedRose.items[0].quality);
    }

    @Test
    void checkAgedBrieNameIncreaseInQualityTheOlderItGets() {
        Item[] items = new Item[]{new Item(AGED_BRIE, 1, 1)};
        GildedRose gildedRose = gildedRoseTest.updateQualityOf(items);
        assertEquals(2, gildedRose.items[0].quality);
    }

    @Test
    void qualityOfAgedBrieIsNeverMoreThan50() {
        Item[] items = new Item[]{new Item(AGED_BRIE, 1, 50)};
        GildedRose gildedRose = gildedRoseTest.updateQualityOf(items);
        assertEquals(50, gildedRose.items[0].quality);
    }

    @Test
    void whenSellInEqualsZeroQualityOfAgedBrieIsNeverMoreThan50() {
        Item[] items = new Item[]{new Item(AGED_BRIE, 0, 50)};
        GildedRose gildedRose = gildedRoseTest.updateQualityOf(items);
        assertEquals(50, gildedRose.items[0].quality);
    }

}
