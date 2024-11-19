package inhatc.cse.yhjshope.item.dto;

import inhatc.cse.yhjshope.item.constant.ItemSellStatus;
import inhatc.cse.yhjshope.item.entity.Item;
import inhatc.cse.yhjshope.item.entity.QItem;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemFormDto {
    private Long id;    //id

    @NotBlank(message = "상품명은 필수 입력 값입니다.")
    private String itemNm;  // 상품명

    @NotNull(message = "가격은 필수 입력값 입니다.")
    private int price;  //가격

    @NotNull(message = "재고 수량은 필수 입력값 입니다.")
    private int stockNumber;    //재고수량

    @NotNull(message = "상품 설명은 필수 입력값 입니다.")
    private String itemDetail;  //상품 상세 설명

    private ItemSellStatus itemSellStatus;

    private List<ItemImgDto> itemImgDtoList = new ArrayList<>();

    private List<Long> itemImgIds = new ArrayList<>();

    private static ModelMapper modelMapper = new ModelMapper();

    public Item createItem(){

        return modelMapper.map(this, Item.class);
    }

    public static ItemFormDto of(Item item){

        return modelMapper.map(item, ItemFormDto.class);

    }


}
