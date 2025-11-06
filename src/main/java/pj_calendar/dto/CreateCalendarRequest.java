package pj_calendar.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateCalendarRequest {
    private String title;
    private String name;
    private String password;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
