package com.kadi.WeatherStatistic.repository;

import com.kadi.WeatherStatistic.model.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StatisticRepository extends JpaRepository<Statistic, Integer> {
}
