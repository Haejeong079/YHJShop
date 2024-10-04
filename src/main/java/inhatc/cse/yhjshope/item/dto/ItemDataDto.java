package inhatc.cse.yhjshope.item.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDataDto {

    private String name;
    private int age;
    private String dept;
    private int grade;

}
