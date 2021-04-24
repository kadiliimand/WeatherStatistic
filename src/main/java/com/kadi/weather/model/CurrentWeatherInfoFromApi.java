package com.kadi.weather.model;

import lombok.Data;

@Data
public class CurrentWeatherInfoFromApi {
    private String temp_c;
    private String wind_mph;
    private String Wind_dir;
}
