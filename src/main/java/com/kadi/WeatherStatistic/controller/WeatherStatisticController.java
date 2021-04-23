package com.kadi.WeatherStatistic.controller;

import com.kadi.WeatherStatistic.service.WeatherStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/statistic")
public class WeatherStatisticController {

    private final WeatherStatisticService weatherStatisticService;

    @Autowired
    public WeatherStatisticController(WeatherStatisticService weatherStatisticService) {
        this.weatherStatisticService = weatherStatisticService;
    }

    @PostMapping("averageOfCity")
    ResponseEntity<String> getAverages(@RequestParam("city") String city){
        return ResponseEntity.ok(weatherStatisticService.getAverages(city));
    }

    @PostMapping("popularWindDir")
    ResponseEntity<List<String>> getWindDirect(@RequestParam("city") String city){
        return ResponseEntity.ok(weatherStatisticService.getWindDirect(city));
    }
}
