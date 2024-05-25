package com.example.hotel_microservice.Service;

import com.example.hotel_microservice.Entities.HotelMaster;

import java.util.List;

public interface IHotelService {
    List<HotelMaster> getHotelList();

    List<HotelMaster> getHotelByCityId(Integer cityid);
}
