package com.kadi.WeatherStatistic.repository;

import com.kadi.WeatherStatistic.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {

}
