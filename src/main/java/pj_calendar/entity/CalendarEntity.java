package pj_calendar.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "CalendarEntity")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CalendarEntity {

    @CreatedDate
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime modifiedAt;

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


    public CalendarEntity(String title, String contents, String name, String password,
                          LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.title = title;
        this.contents = contents;
        this.name = name;
        this.password = password;
//        this.date = date;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public void update(String title, String contents, String name, String password, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.title = title;
        this.name = name;
        this.password = password;
        this.contents = contents;
//        this.date = date;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

}
