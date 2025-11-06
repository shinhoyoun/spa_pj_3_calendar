package pj_calendar.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 이 클래스는 매핑 정보만 제공
@EntityListeners(AuditingEntityListener.class)  // 날짜 자동 관리해줌ㄴ
public abstract class BaseEntity { // 추상 클래스로 선언하는 경우가 많음

    // 생성 시 자동 입력
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    // 수정 시 자동 입력
    @LastModifiedDate
    private LocalDateTime modifiedAt;

}