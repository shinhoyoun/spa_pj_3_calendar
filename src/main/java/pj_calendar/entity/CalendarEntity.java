package pj_calendar.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "CalendarEntity")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@MappedSuperclass  <- 이게 있으면 지정된 클래스는 데이터베이스 테이블과 직접 매핑되지 않아서 상속시키는게 좋음 -> BaseEntity 생성
public class CalendarEntity extends BaseEntity {




    //    일정 제목, 일정 내용, 작성자명, 비밀번호, 작성/수정일
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 50, nullable = false)
    String title;
    @Column(length = 20, nullable = false)
    String name;
    @Column(length = 30, nullable = false)
    String password;
    @Column(length = 300, nullable = false)
    String contents;
//    @Column(length = 15, nullable = false)
//    String date;


    public CalendarEntity(String title, String contents, String name, String password) {
        this.title = title;
        this.contents = contents;
        this.name = name;
        this.password = password;
//        this.date = date;
//        this.createdAt = createdAt;
//        this.modifiedAt = modifiedAt;
    }

    public void update(String title, String contents, String name, String password) {
        this.title = title;
        this.name = name;
        this.password = password;
        this.contents = contents;
//        this.date = date;
//        this.createdAt = createdAt;
//        this.modifiedAt = modifiedAt;
    }

}
