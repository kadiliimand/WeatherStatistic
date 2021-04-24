package com.kadi.weather.repository;

import com.kadi.weather.model.Cities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<Cities, Integer> {
    Cities findByCity(String city);
}

