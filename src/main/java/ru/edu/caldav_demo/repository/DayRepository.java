package ru.edu.caldav_demo.repository;

import java.time.LocalDate;
import java.util.LinkedList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.edu.caldav_demo.dict.CountryEnum;
import ru.edu.caldav_demo.entity.Day;

@Repository
public interface DayRepository extends JpaRepository<Day, Long> {

	@Query("""
			select d from Day d
			where d.countryCode = :country
			and d.date between :startDate and :endDate
			order by d.date
			""")
	LinkedList<Day> findAllBy(@Param("country") CountryEnum country, @Param("startDate") LocalDate startDate,
			@Param("endDate") LocalDate endDate);

}
