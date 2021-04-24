package com.kadi.weather.service;

import com.kadi.weather.model.Cities;

import java.util.List;


public interface BasicService {

    List<Cities> getAllCities();

    String addNewCityInList(String city);

    String deleteCity(String city);
}
