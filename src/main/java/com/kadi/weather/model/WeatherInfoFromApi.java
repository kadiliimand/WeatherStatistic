package com.kadi.weather.model;

import lombok.Data;

@Data
public class WeatherInfoFromApi {
    private LocationInfoFromApi location;
    private CurrentWeatherInfoFromApi current;
}
