package inhatc.cse.yhjshope.item.constant.repository;

import inhatc.cse.yhjshope.item.constant.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByItemNm(String itemNm);

    List<Item> findByItemNmLike(String itemNm);

    List<Item> findByPriceLessThanOrderByPriceDesc(int Price);

    @Query(value = "select i from Item i where i.itemDetail like %:itemDetail% " +
            "order by i.price desc")
    List<Item> findItemDetail(@Param("itemDetail") String itemDetail);

    @Query(value = "select * from item i where i.item_detail like %:itemDetail% " +
            "order by i.price desc", nativeQuery = true)
    List<Item> findItemDetailNative(@Param("itemDetail") String itemDetail);


}