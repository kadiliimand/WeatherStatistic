package com.kadi.weather.controller;

import com.kadi.weather.model.Cities;
import com.kadi.weather.service.BasicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/basic")
@RequiredArgsConstructor
public class BasicController {

    private final BasicService basicService;

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
}
