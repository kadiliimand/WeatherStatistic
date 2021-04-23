package com.kadi.WeatherStatistic.controller;

import com.kadi.WeatherStatistic.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/statistic")
public class StatisticController {

    private final StatisticService statisticService;

    @Autowired
    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @PostMapping("averageTemp")
    ResponseEntity<Double> getAverageTemp(@RequestParam("city") String city){
        return ResponseEntity.ok(statisticService.getAverageTemp(city));
    }

    @PostMapping("averageWindSpeed")
    ResponseEntity<String> getAverageWindSpeed(@RequestParam("city") String city){
        return ResponseEntity.ok(statisticService.getAverageWindSpeed(city));
    }

    @PostMapping("popularWindDir")
    ResponseEntity<String> getPopWindDirect(@RequestParam("city") String city){
        return ResponseEntity.ok(statisticService.getPopWindDirect(city));
    }
}
