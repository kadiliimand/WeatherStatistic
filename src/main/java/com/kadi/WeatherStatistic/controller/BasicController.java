package com.kadi.WeatherStatistic.controller;

import com.kadi.WeatherStatistic.model.Cities;
import com.kadi.WeatherStatistic.model.WeatherInfoFromApi;
import com.kadi.WeatherStatistic.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/basic")
public class BasicController {

    private final BasicService basicService;

    @Autowired
    public BasicController(BasicService basicService) {
        this.basicService = basicService;
    }

    @PostMapping("addCity")
    ResponseEntity<String> addNewCityInList(@RequestParam("city") String city){
        return ResponseEntity.ok(basicService.addNewCityInList(city));
    }

    @GetMapping("listOfCities")
    ResponseEntity<List<Cities>> getAllCities(){
        return ResponseEntity.ok(basicService.getAllCities());
    }

    @DeleteMapping("deleteCity")
    ResponseEntity<String> deleteCity(@RequestParam("city") String city){
        return ResponseEntity.ok(basicService.deleteCity(city));
    }

    @PostMapping("currentForecast")
    ResponseEntity<List<WeatherInfoFromApi>> getCurrentForecast(@RequestParam("city") String city){
        return ResponseEntity.ok(basicService.getCurrentForecast(city));
    }
}
