package com.kadi.WeatherStatistic.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "timestamp")
    private LocalDateTime timestamp;
    @Column(name = "city")
    private Integer city;
    @Column(name = "temperature")
    private Double temperature;
    @Column(name = "wind_speed_mph")
    private Double windSpeed;
    @Column(name = "wind_direction")
    private String windDirection;

}
