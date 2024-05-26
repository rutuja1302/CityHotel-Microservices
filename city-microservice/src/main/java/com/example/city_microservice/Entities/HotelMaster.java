package com.example.city_microservice.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelMaster {
    private Integer hotelid;
    private String hotelname;
    private Integer cityid;
}
