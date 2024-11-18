package inhatc.cse.yhjshope.item.entity;

import inhatc.cse.yhjshope.common.entity.BaseEntity;
import inhatc.cse.yhjshope.item.constant.ItemSellStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    @Column(name = "item_id")
    private Long id;

    @Column(nullable = false, length = 50)
    private String itemNm;

    private int price;

    @Column(name = "stock")
    private int stockNumber;

    @Lob
    @Column(nullable = false)
    private String itemDetail;

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;


    private LocalDateTime regTime;      // 등록일 (추후 제거)
    private LocalDateTime updateTime;   // 수정일 (추후 제거)

}
