package com.kadi.WeatherStatistic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "cities")
public class Cities {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    private String city;

    /*@JsonIgnore
    @OneToMany(mappedBy = "cities")
    private List<Weather> weatherList;*/
}
