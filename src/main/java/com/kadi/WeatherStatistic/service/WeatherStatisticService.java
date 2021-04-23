package com.kadi.WeatherStatistic.service;

import java.util.List;

public interface WeatherStatisticService {
    String getAverages(String city);

    List<String> getWindDirect(String city);
}
