package inhatc.cse.yhjshope.common.entity;


import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(value = {AuditingEntityListener.class})
@MappedSuperclass   // 테이블로 매핑 안하고 자식 클래스에게 매핑 정보만 제공
@Getter
@Setter
public class BaseTimeEntity{

    @CreatedDate
    @Column(updatable = false) //등록 시간
    private LocalDateTime regTime;

    @LastModifiedDate
    private LocalDateTime updateTime;   // 수정 시간


}
