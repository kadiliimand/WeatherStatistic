package com.kadi.WeatherStatistic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    //@Column(name = "city_id", insertable = false, updatable = false)
    private String city;
    private String temperature;
    @Column(name = "wind_speed_mph")
    private String windSpeed;
    @Column(name = "wind_direction")
    private String windDirection;

    /*@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "city_id")
    private Cities cities;*/
}
