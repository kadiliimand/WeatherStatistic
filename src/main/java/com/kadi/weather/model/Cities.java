package com.kadi.weather.model;

import lombok.Data;

import javax.persistence.*;

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
