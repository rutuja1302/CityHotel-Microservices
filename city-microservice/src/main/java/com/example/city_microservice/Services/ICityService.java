package com.example.city_microservice.Services;

import com.example.city_microservice.Entities.CityMaster;

import java.util.List;

public interface ICityService {
    List<CityMaster> getAllCities();
}
