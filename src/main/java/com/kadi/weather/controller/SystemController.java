package com.kadi.weather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/v1/system")
public class SystemController {

    @GetMapping("health")
    public ResponseEntity<String> getHeakth(){
        return ResponseEntity.ok("OK");
    }
}
