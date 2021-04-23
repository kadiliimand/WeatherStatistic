package com.kadi.WeatherStatistic.serviceImpl;

import com.kadi.WeatherStatistic.connector.WeatherapiConnector;
import com.kadi.WeatherStatistic.model.Weather;
import com.kadi.WeatherStatistic.repository.CityRepository;
import com.kadi.WeatherStatistic.repository.WeatherRepository;
import com.kadi.WeatherStatistic.service.WeatherStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherStatisticServiceImpl implements WeatherStatisticService {

    private WeatherapiConnector weatherapiConnector;
    private WeatherRepository weatherRepository;
    private CityRepository cityRepository;

    @Autowired
    public WeatherStatisticServiceImpl(WeatherapiConnector weatherapiConnector, WeatherRepository weatherRepository, CityRepository cityRepository) {
        this.weatherapiConnector = weatherapiConnector;
        this.weatherRepository = weatherRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public String getAverages(String city) {
        List<Weather> listOfData = weatherRepository.findByCity(city);
        if(listOfData.size() >= 3) {
            double sumTemp = 0;
            double averageTemp = 0;
            double sumWindSpeed = 0;
            double averageWindSpeed = 0;

            for (int i = 0; i < listOfData.size(); i++) {
                double temp = Double.parseDouble(listOfData.get(i).getTemperature());
                sumTemp += temp;
                averageTemp = sumTemp / listOfData.size();
            }

            for (int i = 0; i < listOfData.size(); i++) {
                double temp = Double.parseDouble(listOfData.get(i).getWindSpeed());
                sumWindSpeed += temp;
                averageWindSpeed = sumWindSpeed / listOfData.size();
            }
            return city + " average temp: " + averageTemp + " and average wind speed: " + averageWindSpeed;
        }
        return "Insufficient data for statistic!";
    }

    @Override
    public List<String> getWindDirect(String city) {
        List<Weather> listOfData = weatherRepository.findByCity(city);
        if(listOfData.size() >= 3) {
            List<String> listOfWindDir = new ArrayList<>();

            for (int i = 0; i < listOfData.size(); i++) {
                listOfWindDir.add(listOfData.get(i).getWindDirection());
            }

            return listOfWindDir;
        }
        return null; //"Insufficient data for statistic!"
    }
}
