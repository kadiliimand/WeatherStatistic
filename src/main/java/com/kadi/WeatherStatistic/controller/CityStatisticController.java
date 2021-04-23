package com.kadi.WeatherStatistic.controller;

import com.kadi.WeatherStatistic.service.CityStatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cityStatistic")
@RequiredArgsConstructor
public class CityStatisticController {

    private final CityStatisticService cityStatisticService;

    @GetMapping("maxTemp")
    ResponseEntity<String> getCityWithMaxTemp(){
        return ResponseEntity.ok(cityStatisticService.getCityWithMaxTemp());
    }

    @GetMapping("minTemp")
    ResponseEntity<String> getCityWithMinTemp(){
        return ResponseEntity.ok(cityStatisticService.getCityWithMinTemp());
    }
}