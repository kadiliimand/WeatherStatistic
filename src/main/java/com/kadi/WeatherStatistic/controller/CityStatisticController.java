package com.kadi.WeatherStatistic.controller;

import com.kadi.WeatherStatistic.service.CityStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cityStatistic")
public class CityStatisticController {

    private final CityStatisticService cityStatisticService;

    @Autowired
    public CityStatisticController(CityStatisticService cityStatisticService) {
        this.cityStatisticService = cityStatisticService;
    }
}
