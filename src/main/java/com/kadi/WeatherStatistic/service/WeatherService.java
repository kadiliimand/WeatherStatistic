package com.kadi.WeatherStatistic.service;

import com.kadi.WeatherStatistic.model.Cities;
import com.kadi.WeatherStatistic.model.CitiesData;
import com.kadi.WeatherStatistic.model.Weather;
import com.kadi.WeatherStatistic.model.WeatherInfoFromApi;

import java.util.List;


public interface WeatherService {

    List<Cities> getAllCities();

    String addNewCityInList(String city);

    String deleteCity(String city);

    List<WeatherInfoFromApi> getCurrentForecast(String city);

    List<Weather> getAverages();
}
