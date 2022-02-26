package com.gildedrose;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Modifying
    @Query(
            value = "UPDATE ITEM i SET i.sell_in=sell_in , i.quality=quality   WHERE i.id=id",
            nativeQuery = true)
    void updateQuality(@Param("id") int id, @Param("sell_in") int sellIn, @Param("quality") int quality);

//    @Query(value = "SELECT * FROM Orders WHERE Amount BETWEEN :startAmt AND :endAmt" , nativeQuery=true)
//    List<OrderEntity> findOrdersBy(@Param("startAmt") int startAmt, @Param("endAmt") int endAmt);
}
