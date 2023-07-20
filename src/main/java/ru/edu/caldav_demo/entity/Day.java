package ru.edu.caldav_demo.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.edu.caldav_demo.dict.CountryEnum;
import ru.edu.caldav_demo.dict.EventEnum;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name = "days")
public class Day {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "date", nullable = false)
	private LocalDate date;

	@Column(name = "country_code", nullable = false)
	@Enumerated(EnumType.STRING)
	private CountryEnum countryCode;

	@Column(name = "event_name", nullable = false)
	@Enumerated(EnumType.STRING)
	private EventEnum eventName;

}
