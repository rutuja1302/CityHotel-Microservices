package com.example.city_microservice.Services;

import com.example.city_microservice.Entities.CityMaster;
import com.example.city_microservice.Repository.CityMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CItyServiceImpl implements ICityService{
    @Autowired
    CityMasterRepository cityMasterRepository;

    @Override
    public List<CityMaster> getAllCities() {
        return cityMasterRepository.findAll();
    }
}
