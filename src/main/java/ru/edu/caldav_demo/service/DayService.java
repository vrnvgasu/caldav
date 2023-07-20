package ru.edu.caldav_demo.service;

import java.time.LocalDate;
import java.util.List;
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
		return dayRepository.findAllBy(country, startDate, endDate);
	}

}
