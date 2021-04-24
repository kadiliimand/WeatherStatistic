package com.kadi.weather.serviceImpl;

import com.kadi.weather.model.Weather;
import com.kadi.weather.repository.WeatherRepository;
import com.kadi.weather.service.StatisticService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

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
        //double temp = statisticService.getAverageTemp(CITY);
        //double wind = statisticService.getAverageWindSpeed(CITY);
        String direction = statisticService.getPopWindDirect(CITY);
        when(weatherRepository.findByCity(CITY)).thenReturn(dummyList());
        //Assertions.assertEquals(8.2, temp);
        //Assertions.assertEquals(10, wind);
        Assertions.assertEquals("N", direction);
    }

    private List<Weather> dummyList() {
        Weather weather = new Weather();
        weather.setTemperature("3.9");
        weather.setWindSpeed("10");
        weather.setWindDirection("N");

        Weather weather1 = new Weather();
        weather1.setTemperature("12.9");
        weather1.setWindSpeed("12");
        weather1.setWindDirection("N");

        Weather weather2 = new Weather();
        weather2.setTemperature("7.8");
        weather2.setWindSpeed("8");
        weather2.setWindDirection("S");
        return List.of(weather, weather1, weather2);
    }
}