package com.kadi.WeatherStatistic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "statistic")
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "temp_max")
    private Double tempMax;
    @Column(name = "temp_min")
    private Double tempMin;
    @Column(name = "wind_max")
    private Double windMax;
    @Column(name = "wind_min")
    private Double windMin;
    @Column(name = "pop_wind_direction")
    private String popWindDirect;
}
