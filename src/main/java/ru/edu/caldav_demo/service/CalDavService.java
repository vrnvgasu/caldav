package ru.edu.caldav_demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.ZoneId;
import java.util.List;
import lombok.RequiredArgsConstructor;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.component.VEvent;
import org.springframework.stereotype.Service;
import ru.edu.caldav_demo.entity.Day;

@RequiredArgsConstructor
@Service
public class CalDavService {

	private final ObjectMapper mapper;

	public String prepareDaysToJsonSting(List<Day> dayList) throws JsonProcessingException {
		Calendar cal = new Calendar();

		for (Day day : dayList) {
			cal.withComponent(new VEvent(
					new Date(day.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()),
					day.getEventName().getDescription()
			));
		}

		return mapper.writeValueAsString(cal.getFluentTarget());
	}

}
