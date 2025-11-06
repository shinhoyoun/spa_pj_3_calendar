package pj_calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pj_calendar.entity.CalendarEntity;

import java.util.Calendar;

public interface CalendarRepository extends JpaRepository<CalendarEntity, Long> {
}
