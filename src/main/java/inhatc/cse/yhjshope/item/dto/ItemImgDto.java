package inhatc.cse.yhjshope.item.dto;

import inhatc.cse.yhjshope.item.entity.ItemImg;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemImgDto {

    private Long id;    //id
    private String itemNm;  // 상품명
    private String oriImgName;
    private String imgUrl;
    private String repImgYn;

    private static ModelMapper modelMapper = new ModelMapper();

    public static ItemImgDto of(ItemImg itemImage){
        
        return modelMapper.map(itemImage, ItemImgDto.class);
    }
}
