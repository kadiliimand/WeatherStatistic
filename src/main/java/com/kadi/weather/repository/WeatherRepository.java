package com.kadi.weather.repository;

import com.kadi.weather.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {

    List<Weather> findByCity(String city);

}
