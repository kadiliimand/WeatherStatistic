package com.kadi.WeatherStatistic.serviceImpl;

import com.kadi.WeatherStatistic.model.Weather;
import com.kadi.WeatherStatistic.repository.WeatherRepository;
import com.kadi.WeatherStatistic.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatisticServiceImpl implements StatisticService {

    private WeatherRepository weatherRepository;

    @Autowired
    public StatisticServiceImpl(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @Override
    public Double getAverageTemp(String city) {
        List<Weather> listOfData = weatherRepository.findByCity(city);
        if (listOfData.size() >= 3) {
            return averageTempCalc(listOfData);
        }
        return 0.0;
    }

    private double averageTempCalc(List<Weather> listOfData) {
        double sumTemp = 0;
        double averageTemp = 0;

        for (int i = 0; i < listOfData.size(); i++) {
            double temp = Double.parseDouble(listOfData.get(i).getTemperature());
            sumTemp += temp;
            averageTemp = sumTemp / listOfData.size();
        }
        return averageTemp;
    }

    @Override
    public String getAverageWindSpeed(String city) {
        List<Weather> listOfData = weatherRepository.findByCity(city);
        if (listOfData.size() >= 3) {
            return "Average wind speed in " + city + ": " + averageWindSpeedCalc(listOfData) + " mph.";
        }
        return "Insufficient data for statistic!";
    }

    private double averageWindSpeedCalc(List<Weather> listOfData) {
        double sumWindSpeed = 0;
        double averageWindSpeed = 0;
        for (int i = 0; i < listOfData.size(); i++) {
            double temp = Double.parseDouble(listOfData.get(i).getWindSpeed());
            sumWindSpeed += temp;
            averageWindSpeed = sumWindSpeed / listOfData.size();
        }
        return averageWindSpeed;
    }

    @Override
    public String getPopWindDirect(String city) {
        List<Weather> listOfData = weatherRepository.findByCity(city);
        if (listOfData.size() >= 3) {
            return "Most popular wind direction in " + city + " is " + mostPopWindDirect(listOfData);
        }
        return "Insufficient data for statistic!";
    }

    private String mostPopWindDirect(List<Weather> listOfData) {
        List<String> listOfWindDir = new ArrayList<>();
        for (int i = 0; i < listOfData.size(); i++) {
            listOfWindDir.add(listOfData.get(i).getWindDirection());
        }

        Map<String, Integer> map = new HashMap<>();
        for (int j = 0; j < listOfWindDir.size(); j++) {
            Integer count = map.get(listOfWindDir.get(j));
            if(count == null){
                map.put(listOfWindDir.get(j), 1);
            } else {
                map.put(listOfWindDir.get(j), count + 1);
            }
        }
        String mostPopResult = null;
        int maxVal = -1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > maxVal){
                mostPopResult = entry.getKey();
                maxVal = entry.getValue();
            }
        }
        return mostPopResult;
    }


}
