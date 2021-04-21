package com.kadi.WeatherStatistic.connector;

import com.kadi.WeatherStatistic.model.Weather;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class WeatherapiConnector {

    RestTemplate restTemplate = new RestTemplate();

    private static final String API_KEY = "75a639f5c07240c6b9e180827212004";

    @Scheduled
    public List<Weather> getInformation(String city){
        String url = "http://api.weatherapi.com/v1/current.json?key=" + API_KEY + "&q=" + city + "&aqi=no";
        ResponseEntity<Weather> responseEntity = restTemplate.getForEntity(url, Weather.class);
        Weather weatherData = responseEntity.getBody();
        return List.of(weatherData);
    }
}
