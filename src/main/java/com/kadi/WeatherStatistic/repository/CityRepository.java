package com.kadi.WeatherStatistic.repository;

import com.kadi.WeatherStatistic.model.Cities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<Cities, Integer> {
    Cities findByCity(String city);
}

