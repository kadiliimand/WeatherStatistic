package com.kadi.WeatherStatistic.serviceImpl;

import com.kadi.WeatherStatistic.model.Weather;
import com.kadi.WeatherStatistic.repository.WeatherRepository;
import com.kadi.WeatherStatistic.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StatisticServiceImpl implements StatisticService {

    private final WeatherRepository weatherRepository;

    @Override
    public double getAverageTemp(String city) {
        double sumTemp = 0;
        double averageTemp = 0;
        List<Weather> listOfData = weatherRepository.findByCity(city);
        if (listOfData.size() >= 3) {
            for (int i = 0; i < listOfData.size(); i++) {
                double temp = Double.parseDouble(listOfData.get(i).getTemperature());
                sumTemp += temp;
                averageTemp = sumTemp / listOfData.size();
            }
            return averageTemp;
        }
        return 0.0;
    }

    @Override
    public double getAverageWindSpeed(String city) {
        List<Weather> listOfData = weatherRepository.findByCity(city);
        double sumWindSpeed = 0;
        double averageWindSpeed = 0;
        if (listOfData.size() >= 3) {
            for (int i = 0; i < listOfData.size(); i++) {
                double temp = Double.parseDouble(listOfData.get(i).getWindSpeed());
                sumWindSpeed += temp;
                averageWindSpeed = sumWindSpeed / listOfData.size();
            }
            return averageWindSpeed;
        }
        return 0.0;
    }

    @Override
    public String  getPopWindDirect(String city) {
        List<Weather> listOfData = weatherRepository.findByCity(city);
        if (listOfData.size() >= 3) {
            return mostPopWindDirect(listOfData);
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
            map.merge(listOfWindDir.get(j), 1, Integer::sum);
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