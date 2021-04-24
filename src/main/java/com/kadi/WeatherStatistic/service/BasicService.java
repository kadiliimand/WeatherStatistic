package com.kadi.WeatherStatistic.service;

import com.kadi.WeatherStatistic.model.Cities;

import java.util.List;


public interface BasicService {

    List<Cities> getAllCities();

    String addNewCityInList(String city);

    String deleteCity(String city);
}
