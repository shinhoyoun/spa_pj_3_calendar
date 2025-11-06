package pj_calendar.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pj_calendar.dto.*;
import pj_calendar.service.CalendarService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CalendarController {

    private final CalendarService calendarService;

    // 생성
    @PostMapping("/calendars")
    public ResponseEntity<CreateCalendarResponse> createCalendar(@RequestBody CreateCalendarRequest request) {
        CreateCalendarResponse result = calendarService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }

    // 단 건
    @GetMapping("/calendars/{calendarId}")
    public ResponseEntity<GetOneCalendarResponse> getOneCalendar(@PathVariable Long calendarId) {
        GetOneCalendarResponse result = calendarService.getOne(calendarId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 다 건 - 전체
    @GetMapping("/calendars")
    public ResponseEntity<List<GetOneCalendarResponse>> getAllCalendar() {
        List<GetOneCalendarResponse> result = calendarService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 수정 update
    @PutMapping("calendars/{calendarId}")
    public ResponseEntity<UpdateCalendarResponse> update(
            @PathVariable Long calendarId,
            @RequestBody UpdateCalendarRequest request
            ) {
        UpdateCalendarResponse result = calendarService.update(calendarId, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 삭제 delete
    @DeleteMapping("/calendar/{calendarId}")
    public ResponseEntity<Void> delete(@PathVariable Long calendarId) {
        calendarService.delete(calendarId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
