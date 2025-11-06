package pj_calendar.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class CreateCalendarResponse {

    private final Long id;
    private final String title;
    private final String name;
    private final String password;
    private final String contents;
//    private final String date;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CreateCalendarResponse(Long id, String title,
                                  String name, String password,
                                  String contents,
                                  LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.password = password;
        this.contents = contents;
//        this.date = date;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

}
