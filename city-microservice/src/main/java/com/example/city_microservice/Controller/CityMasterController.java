package com.example.city_microservice.Controller;

import com.example.city_microservice.Entities.CityMaster;
import com.example.city_microservice.Services.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityMasterController {

    @Autowired
    ICityService cityService;

    //API to get all city list
    @GetMapping("/getCityList")
    public List<CityMaster> getCityList(){
        return cityService.getAllCities();
    }
}
