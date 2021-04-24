package com.kadi.weather.connector;

import com.kadi.weather.model.WeatherInfoFromApi;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherapiConnector {

    RestTemplate restTemplate = new RestTemplate();

    private static final String API_KEY = "75a639f5c07240c6b9e180827212004";

    public WeatherInfoFromApi getInformation(String city){
        String url = "http://api.weatherapi.com/v1/current.json?key=" + API_KEY + "&q=" + city + "&aqi=no";
        ResponseEntity<WeatherInfoFromApi> responseEntity = restTemplate.getForEntity(url, WeatherInfoFromApi.class);
        return responseEntity.getBody();
    }
}
