package com.kadi.WeatherStatistic.controller;

import com.kadi.WeatherStatistic.model.Cities;
import com.kadi.WeatherStatistic.model.Weather;
import com.kadi.WeatherStatistic.model.WeatherInfoFromApi;
import com.kadi.WeatherStatistic.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping("addCity")
    ResponseEntity<String> addNewCityInList(@RequestParam("city") String city){
        return ResponseEntity.ok(weatherService.addNewCityInList(city));
    }

    @GetMapping("listOfCities")
    ResponseEntity<List<Cities>> getAllCities(){
        return ResponseEntity.ok(weatherService.getAllCities());
    }

    @DeleteMapping("deleteCity")
    ResponseEntity<String> deleteCity(@RequestParam("city") String city){
        return ResponseEntity.ok(weatherService.deleteCity(city));
    }

    @PostMapping("currentForecast")
    ResponseEntity<List<WeatherInfoFromApi>> getCurrentForecast(@RequestParam("city") String city){
        return ResponseEntity.ok(weatherService.getCurrentForecast(city));
    }

    @GetMapping
    ResponseEntity<List<Weather>> getAverages(){
        return ResponseEntity.ok(weatherService.getAverages());
    }

    /*@PutMapping ("cities")
    ResponseEntity<String> getAllSavedCities(){
        weatherService.getAllSavedCities(city));
    }*/
}
