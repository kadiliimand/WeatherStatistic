package com.kadi.WeatherStatistic.service;

import com.kadi.WeatherStatistic.model.Weather;
import java.util.List;

public interface WeatherService {
    List<Weather> getAllSavedCities();
}
