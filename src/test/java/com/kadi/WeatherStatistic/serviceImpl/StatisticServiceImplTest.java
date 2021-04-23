package com.kadi.WeatherStatistic.serviceImpl;

import com.kadi.WeatherStatistic.model.CurrentWeatherInfoFromApi;
import com.kadi.WeatherStatistic.model.WeatherInfoFromApi;
import com.kadi.WeatherStatistic.repository.WeatherRepository;
import com.kadi.WeatherStatistic.service.StatisticService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StatisticServiceImplTest {

    private StatisticService statisticService;

    @Mock
    WeatherRepository weatherRepository;

    @BeforeEach
    void setup(){
        statisticService = new StatisticServiceImpl(weatherRepository);
    }

    @Test
    void functionsTest(){
        Double result = statisticService.getAverageTemp("Tallinn");
        //Assertions.assertArrayEquals(3.9, );
    }

    private String listWithData() {
        WeatherInfoFromApi weatherInfoFromApi = new WeatherInfoFromApi();
        WeatherInfoFromApi weatherInfoFromApi1 = new WeatherInfoFromApi();
        WeatherInfoFromApi weatherInfoFromApi2 = new WeatherInfoFromApi();
        CurrentWeatherInfoFromApi currentWeatherInfoFromApi = new CurrentWeatherInfoFromApi();
        CurrentWeatherInfoFromApi currentWeatherInfoFromApi1 = new CurrentWeatherInfoFromApi();
        CurrentWeatherInfoFromApi currentWeatherInfoFromApi2 = new CurrentWeatherInfoFromApi();
        currentWeatherInfoFromApi.setTemp_c("4.2");
        currentWeatherInfoFromApi1.setTemp_c("5.5");
        currentWeatherInfoFromApi2.setTemp_c("8.9");
        weatherInfoFromApi.setCurrent(currentWeatherInfoFromApi);
        weatherInfoFromApi1.setCurrent(currentWeatherInfoFromApi1);
        weatherInfoFromApi2.setCurrent(currentWeatherInfoFromApi2);
        List<WeatherInfoFromApi> list = new ArrayList<>();
        list.add(weatherInfoFromApi);
        return null;
    }
}