package com.example.city_microservice.Services;

import com.example.city_microservice.Entities.CityMaster;
import com.example.city_microservice.Entities.CityResponse;
import com.example.city_microservice.Entities.HotelMaster;

import java.util.List;

public interface ICityService {
    List<CityMaster> getAllCities();

    List<CityResponse> getAllHotelsInCities();

    List<HotelMaster> getHotelsForCityId(Integer cityid);

    HotelMaster test();
}
