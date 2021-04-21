package com.kadi.WeatherStatistic.serviceImpl;

import com.kadi.WeatherStatistic.connector.WeatherapiConnector;
import com.kadi.WeatherStatistic.model.Weather;
import com.kadi.WeatherStatistic.service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final WeatherapiConnector weatherapiConnector;

    @Override
    public List<Weather> getAllSavedCities() {
        Weather cities = new Weather();
        return List.of(cities);
    }
}
