package com.example.city_microservice.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "citymaster", schema = "public")
@Data
public class CityMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cityid;
    private String cityname;
}
