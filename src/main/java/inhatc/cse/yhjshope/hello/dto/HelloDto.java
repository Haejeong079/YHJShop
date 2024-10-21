package inhatc.cse.yhjshope.hello.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HelloDto {
    private String name;
    private int grade;
    private String dept;

}
