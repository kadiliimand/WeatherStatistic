package com.kadi.WeatherStatistic.serviceImpl;

import com.kadi.WeatherStatistic.model.Statistic;
import com.kadi.WeatherStatistic.model.Weather;
import com.kadi.WeatherStatistic.repository.StatisticRepository;
import com.kadi.WeatherStatistic.repository.WeatherRepository;
import com.kadi.WeatherStatistic.service.CityStatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CityStatisticServiceImpl implements CityStatisticService {

    private final WeatherRepository weatherRepository;

    @Override
    public String getCityWithMaxTemp() {
        List<Weather> listOfAll = weatherRepository.findAll();
        if (listOfAll.size() >= 3) {
            Map<String, Double> map = new HashMap<>();
            for (int i = 0; i < listOfAll.size(); i++) {
                map.put(listOfAll.get(i).getCity(), Double.parseDouble(listOfAll.get(i).getTemperature()));
            }
            Map.Entry<String, Double> cityWithMaxTemp = null;
            for (Map.Entry<String, Double> entry : map.entrySet()){
                if(cityWithMaxTemp == null || entry.getValue().compareTo(cityWithMaxTemp.getValue()) > 0){
                    cityWithMaxTemp = entry;
                }
            }
            return cityWithMaxTemp.getKey();
        }
        return "Insufficient data for statistic!";
    }

    @Override
    public String getCityWithMinTemp() {
        List<Weather> listOfAll = weatherRepository.findAll();
        if (listOfAll.size() >= 3) {
            Map<String, Double> map = new HashMap<>();
            for (int i = 0; i < listOfAll.size(); i++) {
                map.put(listOfAll.get(i).getCity(), Double.parseDouble(listOfAll.get(i).getTemperature()));
            }
            Map.Entry<String, Double> cityWithMinTemp = null;
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                if (cityWithMinTemp == null || entry.getValue().compareTo(cityWithMinTemp.getValue()) < 0) {
                    cityWithMinTemp = entry;
                }
            }
            return cityWithMinTemp.getKey();
        }
        return "Insufficient data for statistic!";
    }
}
