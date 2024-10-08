package inhatc.cse.yhjshope.item.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import inhatc.cse.yhjshope.item.constant.ItemSellStatus;
import inhatc.cse.yhjshope.item.entity.Item;
import inhatc.cse.yhjshope.item.entity.QItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class ItemRepositoryTest2 {
    @Autowired
    private ItemRepository itemRepository;

//    @Autowired
//    private JPAQueryFactory jpaQueryFactory;

    @PersistenceContext
    private EntityManager em;

    public void createItemList(){
        for (int i = 1; i <= 10; i++) {
            Item item= Item.builder()
                    .itemNm("신상품"+i)
                    .itemDetail("신상품 상세 설명"+i)
                    .price(10000+i)
                    .stockNumber(100)
                    .build();

            itemRepository.save(item);

        }
    }

    @Test
    public void test(){
        System.out.println("AAAAAAAAAAAAAA");
    }
    @Test
    @DisplayName("상품등록테스트")
    public void insertItemTest(){
        Item item= Item.builder()
                .itemNm("신상품2")
                .itemDetail("신상품 상세 설명2")
                .price(10000)
                .stockNumber(100)
                .build();

        itemRepository.save(item);
        Item savedItem=itemRepository.save(item);
        System.out.println(savedItem);

    }

    @Test
    public void findByItemNmTest(){
        List<Item> itemList=itemRepository.findByItemNm("신상품2");
        for (Item item : itemList) {
            System.out.println(item);

        }

        itemList.forEach(item -> System.out.println(item));

    }

    @Test
    @DisplayName("OR테스트")
    public void findByItemNmOrItemDetailTest(){
        List<Item> itemlist = itemRepository.findByItemNmOrItemDetail("신상품2", "신상품 상세 설명2");
        itemlist.forEach(item -> {
            System.out.println(item);
        });


    }

    @Test
    @DisplayName("OrderBy테스트")
    public  void findByPriceLessThanOrderByPriceDescTest(){
        itemRepository.findByPriceLessThanOrderByPriceDesc(1005)
                .forEach(System.out::println);

    }


    @Test
    @DisplayName("querydsl 테스트")
    public void querydslTest(){
        createItemList();

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QItem qItem = QItem.item;

        List<Item> itemList = queryFactory.select(qItem)
                .from(qItem)
                .where(qItem.itemDetail.like("%테스트%"))
                .orderBy(qItem.price.desc())
                .fetch();

        itemList.forEach(item -> System.out.println(item));

//        for (Item item : itemList) {
//            System.out.println(item);
//        }

    }

    // 데이터 준비
    public void createItemList2(){
        for(int i=1;i<=5;i++){
            Item item = new Item();
            item.setItemNm("테스트 상품" + i);
            item.setPrice(10000 + i);
            item.setItemDetail("테스트 상품 상세 설명" + i);
            item.setItemSellStatus(ItemSellStatus.SELL);
            item.setStockNumber(100);
            item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());
            itemRepository.save(item);
        }

        for(int i=6;i<=10;i++){
            Item item = new Item();
            item.setItemNm("테스트 상품" + i);
            item.setPrice(10000 + i);
            item.setItemDetail("테스트 상품 상세 설명" + i);
            item.setItemSellStatus(ItemSellStatus.SOLD_OUT);
            item.setStockNumber(0);
            item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());
            itemRepository.save(item);
        }
    }


}
