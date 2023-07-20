package ru.edu.caldav_demo.service;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static ru.edu.caldav_demo.dict.EventEnum.WEEKEND;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.edu.caldav_demo.dict.CountryEnum;
import ru.edu.caldav_demo.entity.Day;
import ru.edu.caldav_demo.repository.DayRepository;

@RequiredArgsConstructor
@Service
public class DayService {

	private final DayRepository dayRepository;

	public List<Day> getDayListBy(CountryEnum country, LocalDate startDate, LocalDate endDate) {
		List<Day> days = startDate.datesUntil(endDate)
				.filter(d -> d.getDayOfWeek() == SATURDAY || d.getDayOfWeek() == SUNDAY)
				.map(d -> Day.builder()
						.date(d)
						.countryCode(country)
						.eventName(WEEKEND)
						.build())
				.collect(Collectors.toCollection(LinkedList::new));
		days.addAll(dayRepository.findAllBy(country, startDate, endDate));
		days.sort(Comparator.comparing(Day::getDate));
		return days;
	}

}
