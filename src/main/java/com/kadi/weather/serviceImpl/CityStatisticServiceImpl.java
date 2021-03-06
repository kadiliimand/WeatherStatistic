package com.kadi.weather.serviceImpl;

import com.kadi.weather.exception.WeatherException;
import com.kadi.weather.model.Weather;
import com.kadi.weather.repository.WeatherRepository;
import com.kadi.weather.service.CityStatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CityStatisticServiceImpl implements CityStatisticService {

    private final WeatherRepository weatherRepository;
    private final StatisticServiceImpl statisticService;

    String ERROR_MESSAGE = "Insufficient data for statistic!";

    @Override
    public String getCityWithMaxTemp() {
        List<Weather> listOfAll = weatherRepository.findAll();
        if (listOfAll.size() >= 3) {
            Map<String, Double> map = new HashMap<>();
            for (Weather weather : listOfAll) {
                map.put(weather.getCity(), statisticService.getAverageTemp(weather.getCity()));
            }
            Map.Entry<String, Double> cityWithMaxTemp = null;
            for (Map.Entry<String, Double> entry : map.entrySet()){
                if(cityWithMaxTemp == null || entry.getValue().compareTo(cityWithMaxTemp.getValue()) > 0){
                    cityWithMaxTemp = entry;
                }
            }
            assert cityWithMaxTemp != null;
            return cityWithMaxTemp.getKey();
        }
        throw new WeatherException(ERROR_MESSAGE);
    }

    @Override
    public String getCityWithMinTemp() {
        List<Weather> listOfAll = weatherRepository.findAll();
        if (listOfAll.size() >= 3) {
            Map<String, Double> map = new HashMap<>();
            for (Weather weather : listOfAll) {
                map.put(weather.getCity(), statisticService.getAverageTemp(weather.getCity()));
            }
            Map.Entry<String, Double> cityWithMinTemp = null;
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                if (cityWithMinTemp == null || entry.getValue().compareTo(cityWithMinTemp.getValue()) < 0) {
                    cityWithMinTemp = entry;
                }
            }
            assert cityWithMinTemp != null;
            return cityWithMinTemp.getKey();
        }
        throw new WeatherException(ERROR_MESSAGE);
    }

    @Override
    public String getCityWithMaxWind() {
        List<Weather> listOfAll = weatherRepository.findAll();
        if (listOfAll.size() >= 3) {
            Map<String, Double> map = new HashMap<>();
            for (Weather weather : listOfAll) {
                map.put(weather.getCity(), statisticService.getAverageWindSpeed(weather.getCity()));
            }
            Map.Entry<String, Double> cityWithMaxWind = null;
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                if (cityWithMaxWind == null || entry.getValue().compareTo(cityWithMaxWind.getValue()) > 0) {
                    cityWithMaxWind = entry;
                }
            }
            assert cityWithMaxWind != null;
            return cityWithMaxWind.getKey();
        }
        throw new WeatherException(ERROR_MESSAGE);
    }

    @Override
    public String getCityWithMinWind() {
        List<Weather> listOfAll = weatherRepository.findAll();
        if (listOfAll.size() >= 3) {
            Map<String, Double> map = new HashMap<>();
            for (Weather weather : listOfAll) {
                map.put(weather.getCity(), statisticService.getAverageWindSpeed(weather.getCity()));
            }
            Map.Entry<String, Double> cityWithMinWind = null;
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                if (cityWithMinWind == null || entry.getValue().compareTo(cityWithMinWind.getValue()) < 0) {
                    cityWithMinWind = entry;
                }
            }
            assert cityWithMinWind != null;
            return cityWithMinWind.getKey();
        }
        throw new WeatherException(ERROR_MESSAGE);
    }
}
