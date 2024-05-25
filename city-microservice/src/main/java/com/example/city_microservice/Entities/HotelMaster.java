package com.example.city_microservice.Entities;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class HotelMaster {
    private Integer hotelid;
    private String hotelname;
    private Integer cityid;
}
