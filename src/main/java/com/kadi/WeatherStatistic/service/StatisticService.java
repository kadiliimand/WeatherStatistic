package com.kadi.WeatherStatistic.service;

public interface StatisticService {
    double getAverageTemp(String city);

    double getAverageWindSpeed(String city);

    String getPopWindDirect(String city);
}
