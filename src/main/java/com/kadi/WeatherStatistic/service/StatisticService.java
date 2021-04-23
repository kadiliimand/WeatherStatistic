package com.kadi.WeatherStatistic.service;

import java.util.List;

public interface StatisticService {
    Double getAverageTemp(String city);

    String getAverageWindSpeed(String city);

    String getPopWindDirect(String city);
}
