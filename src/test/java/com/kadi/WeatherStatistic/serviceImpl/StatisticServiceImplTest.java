package com.kadi.WeatherStatistic.serviceImpl;

import com.kadi.WeatherStatistic.model.CurrentWeatherInfoFromApi;
import com.kadi.WeatherStatistic.model.Weather;
import com.kadi.WeatherStatistic.model.WeatherInfoFromApi;
import com.kadi.WeatherStatistic.repository.WeatherRepository;
import com.kadi.WeatherStatistic.service.StatisticService;
import liquibase.pro.packaged.C;
import liquibase.pro.packaged.W;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StatisticServiceImplTest {

    private StatisticService statisticService;

    @Mock
    WeatherRepository weatherRepository;

    String CITY = "Tallinn";

    @BeforeEach
    void setup(){
        statisticService = new StatisticServiceImpl(weatherRepository);
    }

    @Test
    void functionsTest(){
        double temp = statisticService.getAverageTemp(CITY);
        double wind = statisticService.getAverageWindSpeed(CITY);
        String direction = statisticService.getPopWindDirect(CITY);
        when(weatherRepository.findByCity(CITY)).thenReturn(createList());
        //Assertions.assertEquals(8.2, temp);
        //Assertions.assertEquals(10, wind);
        Assertions.assertEquals("N", direction);
    }

    private List<Weather> createList() {
        Weather weather = new Weather();
        Weather weather1 = new Weather();
        Weather weather2 = new Weather();
        weather.setTemperature("3.9");
        weather.setWindSpeed("10");
        weather.setWindDirection("N");
        weather1.setTemperature("12.9");
        weather1.setWindSpeed("12");
        weather1.setWindDirection("N");
        weather2.setTemperature("7.8");
        weather2.setWindSpeed("8");
        weather2.setWindDirection("S");
        return List.of(weather, weather1, weather2);
    }
}