package com.kadi.WeatherStatistic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String timestamp;
    @Column(name = "city_id", insertable = false, updatable = false)
    private Integer cityId;
    private String temperature;
    @Column(name = "wind_speed_mph")
    private String windSpeed;
    @Column(name = "wind_direction")
    private String windDirection;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private Cities cities;
}
