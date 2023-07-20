package ru.edu.caldav_demo.dict;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EventEnum {
	HOLIDAY("праздничный день"),
	WORKING_WEEKEND("рабочий выходной"),
	MOVED_HOLIDAY("перенесенный праздничный день"),
	SHORT_WORK_DAY("сокращенный рабочий день");

	@Getter
	private final String description;

}
