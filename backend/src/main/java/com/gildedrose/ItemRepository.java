package com.gildedrose;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Query(
            value = "SELECT * FROM ITEM",
            nativeQuery = true)
    List<Item> getAllItems();

    @Query(
            value = "SELECT * FROM ITEM WHERE name LIKE 'Aged Brie%'",
            nativeQuery = true)
    List<Item> getAgedBrieItems();
}
