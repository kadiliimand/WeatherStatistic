package com.kadi.WeatherStatistic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WeatherStatisticApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherStatisticApplication.class, args);
	}

}
