package com.kadi.WeatherStatistic.repository;

import com.kadi.WeatherStatistic.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {

    List<Weather> findByCity(String city);

}
