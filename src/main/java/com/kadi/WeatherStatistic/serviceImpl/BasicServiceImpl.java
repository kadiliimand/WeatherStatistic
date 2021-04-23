package com.kadi.WeatherStatistic.serviceImpl;

import com.kadi.WeatherStatistic.connector.WeatherapiConnector;
import com.kadi.WeatherStatistic.model.Cities;
import com.kadi.WeatherStatistic.model.Weather;
import com.kadi.WeatherStatistic.model.WeatherInfoFromApi;
import com.kadi.WeatherStatistic.repository.CityRepository;
import com.kadi.WeatherStatistic.repository.WeatherRepository;
import com.kadi.WeatherStatistic.service.BasicService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasicServiceImpl implements BasicService {

    private final WeatherapiConnector weatherapiConnector;
    private final WeatherRepository weatherRepository;
    private final CityRepository cityRepository;

    @Scheduled(fixedDelay = 90000)
    public void scheduledUpdateOfData(){
        List<Cities> listOfCities = cityRepository.findAll();
        Weather weather = new Weather();
        for (int i = 0; i < listOfCities.size(); i++) {
            String city = listOfCities.get(i).getCity();
            WeatherInfoFromApi weatherInfoFromApi = weatherapiConnector.getInformation(city);
            weather.setCity(weatherInfoFromApi.getLocation().getName());
            weather.setTemperature(weatherInfoFromApi.getCurrent().getTemp_c());
            weather.setTimestamp(weatherInfoFromApi.getLocation().getLocaltime());
            weather.setWindDirection(weatherInfoFromApi.getCurrent().getWind_dir());
            weather.setWindSpeed(weatherInfoFromApi.getCurrent().getWind_mph());
            weatherRepository.save(weather);
        }
    }

    public String addNewCityInList(String city) {
        Cities existingCity = cityRepository.findByCity(city);
        if (existingCity != null){
            return "This city is already in list!";
        }
        Cities cities = new Cities();
        cities.setCity(city);
        cityRepository.save(cities);
        WeatherInfoFromApi weatherInfoFromApi = weatherapiConnector.getInformation(city);
        Weather weather = new Weather();
        weather.setCity(weatherInfoFromApi.getLocation().getName());
        weather.setTemperature(weatherInfoFromApi.getCurrent().getTemp_c());
        weather.setTimestamp(weatherInfoFromApi.getLocation().getLocaltime());
        weather.setWindDirection(weatherInfoFromApi.getCurrent().getWind_dir());
        weather.setWindSpeed(weatherInfoFromApi.getCurrent().getWind_mph());
        weatherRepository.save(weather);
        return "New city added to the list!";
    }

    @Override
    public List<Cities> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public String deleteCity(String city) {
        Cities id = cityRepository.findByCity(city);
        cityRepository.deleteById(id.getId());
        return "Deleted!";
    }

    @Override
    public List<WeatherInfoFromApi> getCurrentForecast(String city) {
        WeatherInfoFromApi weatherInfoFromApi = weatherapiConnector.getInformation(city);
        Cities existingCity = cityRepository.findByCity(city);
        if (existingCity != null) {
            Weather weather = new Weather();
            weather.setCity(weatherInfoFromApi.getLocation().getName());
            weather.setTemperature(weatherInfoFromApi.getCurrent().getTemp_c());
            weather.setTimestamp(weatherInfoFromApi.getLocation().getLocaltime());
            weather.setWindDirection(weatherInfoFromApi.getCurrent().getWind_dir());
            weather.setWindSpeed(weatherInfoFromApi.getCurrent().getWind_mph());
            weatherRepository.save(weather);
        }
        return List.of(weatherInfoFromApi);
    }
}
