package com.example.city_microservice.Controller;

import com.example.city_microservice.Entities.CityMaster;
import com.example.city_microservice.Entities.CityResponse;
import com.example.city_microservice.Entities.HotelMaster;
import com.example.city_microservice.Services.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    //Get All cities & their corresponding hotels
    @GetMapping("/getAllHotelsInCities")
    public List<CityResponse> getCitiesAndHotels(){
        return cityService.getAllHotelsInCities();
    }

    //implementation of feign client to get hotel list for a city id
    @GetMapping("/gethotelbyid")
    public List<HotelMaster> gethotelbyid(@RequestParam("cityid")Integer cityid){
        return cityService.getHotelsForCityId(cityid);
    }

    //Test Fault Tolerance
    @GetMapping("/fault-tolerance-testing")
    public HotelMaster test(){
        return cityService.test();
    }

}
