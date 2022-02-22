package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {
    public GildedRose updateQualityOf(Item[] items) {
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        return gildedRose;
    }

    @Test
    void sellInAndQualityValuesDecreaseAfterUpdate() {
        Item[] items = new Item[]{new Item("foo", 1, 1)};
        GildedRose gildedRose = updateQualityOf(items);
        assertEquals(0, gildedRose.items[0].sellIn);
        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    void whenSellInEqualsZeroQualityDegradesTwiceAsFast() {
        Item[] items = new Item[]{new Item("foo", 0, 6)};
        GildedRose gildedRose = updateQualityOf(items);
        assertEquals(4, gildedRose.items[0].quality);
    }

    @Test
    void qualityOfNormalItemDecreasesQualityIs49() {
        Item[] items = new Item[]{new Item("foo", 1, 49)};
        GildedRose gildedRose = updateQualityOf(items);
        assertEquals(48, gildedRose.items[0].quality);
    }

    @Test
    void whenSellInIsNotEqualZeroTheQualityOfAnItemIsNeverNegative() {
        Item[] items = new Item[]{new Item("foo", 1, 0)};
        GildedRose gildedRose = updateQualityOf(items);
        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    void whenSellInEqualsZeroTheQualityOfAnItemIsNeverNegative() {
        Item[] items = new Item[]{new Item("foo", 0, 1)};
        GildedRose gildedRose = updateQualityOf(items);
        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    void agedBrieIncreaseInQualityTheOlderItGets() {
        Item[] items = new Item[]{new Item("Aged Brie", 1, 1)};
        GildedRose gildedRose = updateQualityOf(items);
        assertEquals(2, gildedRose.items[0].quality);
    }

    @Test
    void checkAgedBrieNameIncreaseInQualityTheOlderItGets() {
        Item[] items = new Item[]{new Item("Aged Brie", 1, 1)};
        GildedRose gildedRose = updateQualityOf(items);
        assertEquals(2, gildedRose.items[0].quality);
    }

    @Test
    void qualityOfNormalItemIsNeverMoreThan50() {
        Item[] items = new Item[]{new Item("foo", 1, 51)};
        GildedRose gildedRose = updateQualityOf(items);
        assertEquals(50, gildedRose.items[0].quality);
    }

    @Test
    void qualityOfAgedBrieIsNeverMoreThan50() {
        Item[] items = new Item[]{new Item("Aged Brie", 1, 50)};
        GildedRose gildedRose = updateQualityOf(items);
        assertEquals(50, gildedRose.items[0].quality);
    }

    @Test
    void whenSellInEqualsZeroQualityOfAgedBrieIsNeverMoreThan50() {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 50)};
        GildedRose gildedRose = updateQualityOf(items);
        assertEquals(50, gildedRose.items[0].quality);
    }

    @Test
    void sulfurasNeverDecreaseInQualityWhenSellInEqualsZero() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        GildedRose gildedRose = updateQualityOf(items);
        assertEquals(80, gildedRose.items[0].quality);
    }

    @Test
    void sulfurasNeverDecreaseInQualityWhenSellInIsDoesNotEqualZero() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 1, 80)};
        GildedRose gildedRose = updateQualityOf(items);
        assertEquals(80, gildedRose.items[0].quality);
    }
}
