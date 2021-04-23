package com.kadi.WeatherStatistic.controller;

import com.kadi.WeatherStatistic.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/statistic")
@RequiredArgsConstructor
public class StatisticController {

    private final StatisticService statisticService;

    @PostMapping("averageTemp")
    double getAverageTemp(@RequestParam("city") String city){
        return statisticService.getAverageTemp(city);
    }

    @PostMapping("averageWindSpeed")
    double getAverageWindSpeed(@RequestParam("city") String city){
        return statisticService.getAverageWindSpeed(city);
    }

    @PostMapping("popularWindDir")
    String getPopWindDirect(@RequestParam("city") String city){
        return statisticService.getPopWindDirect(city);
    }
}
