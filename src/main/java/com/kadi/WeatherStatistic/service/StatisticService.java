package com.kadi.WeatherStatistic.service;

public interface StatisticService {
    Double getAverageTemp(String city);

    Double getAverageWindSpeed(String city);

    String getPopWindDirect(String city);
}
