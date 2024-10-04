package inhatc.cse.yhjshope.item.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {

    private Long id;    //id
    private String itemNm;  // 상품명
    private int price;  //가격
    private int stockNumber;    //재고수량
    private String itemDetail;  //상품 상세 설명

}
