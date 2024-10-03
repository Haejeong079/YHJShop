package inhatc.cse.yhjshope.item.constant.repository;

import inhatc.cse.yhjshope.item.constant.entity.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    @DisplayName("상품 저장 테스트")
    public void insertItemTest(){
        Item item = Item.builder()
                .itemNm("테스트 상품")
                .itemDetail("테스트 상품 상세 설명")
                .price(10000)
                .stockNumber(100)
                .build();

        Item savedItem = itemRepository.save(item);
        assertEquals(savedItem.getId(),3);
    }

    @Test
    public void findByItemNmTest(){
        List<Item> itemNmList =  itemRepository.findByItemNm("추가상품");
        itemNmList.forEach(System.out::println);
    }

}