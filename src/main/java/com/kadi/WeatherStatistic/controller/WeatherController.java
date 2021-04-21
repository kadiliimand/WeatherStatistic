package com.kadi.WeatherStatistic.controller;

import com.kadi.WeatherStatistic.model.Weather;
import com.kadi.WeatherStatistic.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/weather")
@RequiredArgsConstructor
public class WeatherController {

    public final WeatherService weatherService;

    @GetMapping("cities")
    ResponseEntity<List<Weather>> getAllSavedCities(){
        return ResponseEntity.ok(weatherService.getAllSavedCities());
    }
}
