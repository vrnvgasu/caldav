package ru.edu.caldav_demo.service;

import lombok.RequiredArgsConstructor;
import ru.edu.caldav_demo.repository.DayRepository;

@RequiredArgsConstructor
public class DayService {

	private final DayRepository dayRepository;

}
