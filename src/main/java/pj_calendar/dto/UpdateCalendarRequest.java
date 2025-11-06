package pj_calendar.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateCalendarRequest {
    private String title;
    private String name;
    private String contents;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
