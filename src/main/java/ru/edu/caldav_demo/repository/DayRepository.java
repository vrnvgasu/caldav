package ru.edu.caldav_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.edu.caldav_demo.entity.Day;

@Repository
public interface DayRepository extends JpaRepository<Day, Long> {

}
