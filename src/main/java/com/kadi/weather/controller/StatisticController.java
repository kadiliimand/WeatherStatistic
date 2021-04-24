package com.kadi.weather.controller;

import com.kadi.weather.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/statistic")
@RequiredArgsConstructor
public class StatisticController {

    private final StatisticService statisticService;

    @PostMapping("averageTemp")
    ResponseEntity<Double> getAverageTemp(@RequestParam("city") String city){
        return ResponseEntity.ok(statisticService.getAverageTemp(city));
    }

    @PostMapping("averageWindSpeed")
    ResponseEntity<Double> getAverageWindSpeed(@RequestParam("city") String city){
        return ResponseEntity.ok(statisticService.getAverageWindSpeed(city));
    }

    @PostMapping("popularWindDir")
    ResponseEntity<String> getPopWindDirect(@RequestParam("city") String city){
        return ResponseEntity.ok(statisticService.getPopWindDirect(city));
    }
}
