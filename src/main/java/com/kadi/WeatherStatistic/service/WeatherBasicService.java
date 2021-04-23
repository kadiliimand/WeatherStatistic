package com.kadi.WeatherStatistic.service;

import com.kadi.WeatherStatistic.model.Cities;
import com.kadi.WeatherStatistic.model.WeatherInfoFromApi;

import java.util.List;


public interface WeatherBasicService {

    List<Cities> getAllCities();

    String addNewCityInList(String city);

    String deleteCity(String city);

    List<WeatherInfoFromApi> getCurrentForecast(String city);

}
