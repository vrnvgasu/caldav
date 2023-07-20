package ru.edu.caldav_demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.edu.caldav_demo.dict.CountryEnum;
import ru.edu.caldav_demo.entity.Day;
import ru.edu.caldav_demo.service.CalDavService;
import ru.edu.caldav_demo.service.DayService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/caldav")
public class CalDavController {

	private final DayService dayService;

	private final CalDavService calDavService;

	@GetMapping("/country/{country}/dt_start/{dateStart}/dt_end/{dateEnd}")
	public ResponseEntity<String> getEmployeeLeagueGuidList(
			@PathVariable CountryEnum country,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateStart,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateEnd
	) throws JsonProcessingException {
		List<Day> dayListBy = dayService.getDayListBy(country, dateStart, dateEnd);
		return new ResponseEntity<>(calDavService.prepareDaysToJsonSting(dayListBy), HttpStatus.OK);
	}

}
