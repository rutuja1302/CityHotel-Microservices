package com.example.city_microservice.Services;

import com.example.city_microservice.Entities.CityMaster;
import com.example.city_microservice.Entities.CityResponse;

import java.util.List;

public interface ICityService {
    List<CityMaster> getAllCities();

    List<CityResponse> getAllHotelsInCities();
}
