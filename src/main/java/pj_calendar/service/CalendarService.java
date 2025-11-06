package pj_calendar.service;

import pj_calendar.dto.*;
import pj_calendar.entity.CalendarEntity;
import pj_calendar.repository.CalendarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalendarService {

    private final CalendarRepository calendarRepository;

    // 현재 시간 데이터 저장
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    String nowstring = format.format(new Date());


    // 저장
    @Transactional
    public CreateCalendarResponse save(CreateCalendarRequest request) {
        CalendarEntity calendar = new CalendarEntity(
                request.getTitle(),
                request.getName(),
                request.getPassword(),
                request.getContents()
//                request.getDate(),
//                request.getCreatedAt(),
//                request.getModifiedAt()
        );

        CalendarEntity savedCalendar = calendarRepository.save(calendar);

        return new CreateCalendarResponse(
                savedCalendar.getId(),
                savedCalendar.getTitle(),
                savedCalendar.getName(),
                savedCalendar.getPassword(),
                savedCalendar.getContents(),
//                savedCalendar.getDate(),
                savedCalendar.getCreatedAt(),
                savedCalendar.getModifiedAt()
        );
    }

    // 단 건 조회
    @Transactional(readOnly = true)
    public GetOneCalendarResponse getOne(Long calendarId) {
        CalendarEntity calendarEntity = calendarRepository.findById(calendarId).orElseThrow(
                () -> new IllegalStateException("X - calendarId - one")
        );

        return new GetOneCalendarResponse(
                calendarEntity.getId(),
                calendarEntity.getTitle(),
                calendarEntity.getName(),
                calendarEntity.getPassword(),
                calendarEntity.getContents(),
//                calendarEntity.getDate(),
                calendarEntity.getCreatedAt(),
                calendarEntity.getModifiedAt()
        );
    }

    // 다 건 조회
    @Transactional(readOnly = true)
    public List<GetOneCalendarResponse> getAll() {
        List<CalendarEntity> calendars = calendarRepository.findAll();

        List<GetOneCalendarResponse> dtos = new ArrayList<>();
        for (CalendarEntity calendarEntity : calendars) {
            GetOneCalendarResponse dto = new GetOneCalendarResponse(
                    calendarEntity.getId(),
                    calendarEntity.getTitle(),
                    calendarEntity.getName(),
                    calendarEntity.getPassword(),
                    calendarEntity.getContents(),
//                    calendarEntity.getDate(),
                    calendarEntity.getCreatedAt(),
                    calendarEntity.getModifiedAt()
            );
            dtos.add(dto);
        }
        return dtos;
    }

    @Transactional
    public UpdateCalendarResponse update(Long calendarId, UpdateCalendarRequest request) {
        CalendarEntity calendarEntity = calendarRepository.findById(calendarId).orElseThrow(    // repository에 담겨있는 데이터를 가지고와서 orelseThrow로 i
                () -> new IllegalStateException("X - calendarId - update")
        );
        
        // 비번 체크
        if (!calendarEntity.getPassword().equals((request.getPassword()))) {
            throw new IllegalArgumentException("비밀번호 틀림");
        }
        
        // 수정 진행
        calendarEntity.update(
                // 가져온 데이터를 내가 넣은 값으로 수정되게
                request.getTitle(),
                request.getName(),
                request.getPassword(),
                request.getContents()
//                calendarEntity.getDate(),
//                calendarEntity.getCreatedAt(),
//                calendarEntity.getModifiedAt()
        );

        return new UpdateCalendarResponse(
                calendarEntity.getId(),
                calendarEntity.getTitle(),
                calendarEntity.getName(),
                calendarEntity.getPassword(),
                calendarEntity.getContents(),
//                calendarEntity.getDate(),
                calendarEntity.getCreatedAt(),
                calendarEntity.getModifiedAt()
        );
    }

    @Transactional
    public void delete(Long calendarId, String password) {
//        boolean existence = calendarRepository.existsById(calendarId);

        CalendarEntity calendarEntity = calendarRepository.findById(calendarId).orElseThrow(
                () -> new IllegalStateException("X - calendar - delete")
        );

        // 없는 경우
//        if(!existence) {
//            throw new IllegalArgumentException("X - calendarId - delete t");
//        }

        // 비번 체크
        if (!calendarEntity.getPassword().equals(password)) {
            throw new IllegalArgumentException("비번이 틀립니다.");
        }
        // 있는 경우
        calendarRepository.deleteById(calendarId);
    }


}