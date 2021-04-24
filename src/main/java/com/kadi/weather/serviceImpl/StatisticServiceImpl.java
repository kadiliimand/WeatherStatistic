package com.kadi.weather.serviceImpl;

import com.kadi.weather.exception.WeatherException;
import com.kadi.weather.model.Weather;
import com.kadi.weather.repository.WeatherRepository;
import com.kadi.weather.service.StatisticService;
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

    String ERROR_MESSAGE = "Insufficient data for statistic!";

    @Override
    public Double getAverageTemp(String city) {
        List<Weather> listOfData = weatherRepository.findByCity(city);
        double sumTemp = 0;
        double averageTemp = 0;
        if (listOfData.size() >= 3) {
            for (int i = 0; i < listOfData.size(); i++) {
                double temp = Double.parseDouble(listOfData.get(i).getTemperature());
                sumTemp += temp;
                averageTemp = sumTemp / listOfData.size();
            }
            return averageTemp;
        }
        throw new WeatherException(ERROR_MESSAGE);
    }

    @Override
    public Double getAverageWindSpeed(String city) {
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
        throw new WeatherException(ERROR_MESSAGE);
    }

    @Override
    public String getPopWindDirect(String city) {
        List<Weather> listOfData = weatherRepository.findByCity(city);
        if (listOfData.size() >= 3) {
            return mostPopWindDirect(listOfData);
        }
        throw new WeatherException(ERROR_MESSAGE);
    }

    private String mostPopWindDirect(List<Weather> listOfData) {
        List<String> listOfWindDir = new ArrayList<>();
        for (Weather listOfDatum : listOfData) {
            listOfWindDir.add(listOfDatum.getWindDirection());
        }

        Map<String, Integer> map = new HashMap<>();
        for (String s : listOfWindDir) {
            map.merge(s, 1, Integer::sum);
        }
        String mostPopResult = null;
        int maxVal = -1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxVal) {
                mostPopResult = entry.getKey();
                maxVal = entry.getValue();
            }
        }
        return mostPopResult;
    }
}
