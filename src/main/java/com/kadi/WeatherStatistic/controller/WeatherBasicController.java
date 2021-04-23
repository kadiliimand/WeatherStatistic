package com.kadi.WeatherStatistic.controller;

import com.kadi.WeatherStatistic.model.Cities;
import com.kadi.WeatherStatistic.model.WeatherInfoFromApi;
import com.kadi.WeatherStatistic.service.WeatherBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/basic")
public class WeatherBasicController {

    private final WeatherBasicService weatherBasicService;

    @Autowired
    public WeatherBasicController(WeatherBasicService weatherBasicService) {
        this.weatherBasicService = weatherBasicService;
    }

    @PostMapping("addCity")
    ResponseEntity<String> addNewCityInList(@RequestParam("city") String city){
        return ResponseEntity.ok(weatherBasicService.addNewCityInList(city));
    }

    @GetMapping("listOfCities")
    ResponseEntity<List<Cities>> getAllCities(){
        return ResponseEntity.ok(weatherBasicService.getAllCities());
    }

    @DeleteMapping("deleteCity")
    ResponseEntity<String> deleteCity(@RequestParam("city") String city){
        return ResponseEntity.ok(weatherBasicService.deleteCity(city));
    }

    @PostMapping("currentForecast")
    ResponseEntity<List<WeatherInfoFromApi>> getCurrentForecast(@RequestParam("city") String city){
        return ResponseEntity.ok(weatherBasicService.getCurrentForecast(city));
    }
}
