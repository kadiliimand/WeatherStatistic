package com.kadi.weather.serviceImpl;

import com.kadi.weather.model.Weather;
import com.kadi.weather.repository.WeatherRepository;
import com.kadi.weather.service.CityStatisticService;
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
public class CityStatisticServiceImplTest {

    private CityStatisticService cityStatisticService;
    private StatisticServiceImpl statisticService;

    @Mock
    WeatherRepository weatherRepository;

    @BeforeEach
    void setup(){
        cityStatisticService = new CityStatisticServiceImpl(weatherRepository, statisticService);
    }

    @Test
    void methodTest(){
        when(weatherRepository.findAll()).thenReturn(dummyList());
        String minTemp = cityStatisticService.getCityWithMinTemp();
        Assertions.assertNotNull(minTemp);
    }

    private List<Weather> dummyList() {
        Weather weather = new Weather();
        weather.setTemperature("3.9");
        weather.setWindSpeed("10");

        Weather weather1 = new Weather();
        weather1.setTemperature("12.9");
        weather1.setWindSpeed("12");

        Weather weather2 = new Weather();
        weather2.setTemperature("7.8");
        weather2.setWindSpeed("8");
        return List.of(weather, weather1, weather2);
    }
}
