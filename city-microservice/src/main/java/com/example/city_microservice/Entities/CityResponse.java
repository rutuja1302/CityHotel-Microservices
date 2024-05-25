package com.example.city_microservice.Entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class CityResponse {
    private Integer cityid;
    private String cityname;
    private List<HotelMaster> hotelMaster;
}
