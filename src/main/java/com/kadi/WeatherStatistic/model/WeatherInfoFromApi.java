package com.kadi.WeatherStatistic.model;

import lombok.Data;

@Data
public class WeatherInfoFromApi {
    private LocationInfoFromApi location;
    private CurrentWeatherInfoFromApi current;
}
