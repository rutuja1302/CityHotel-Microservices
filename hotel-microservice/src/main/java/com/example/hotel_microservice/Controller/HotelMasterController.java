package com.example.hotel_microservice.Controller;

import com.example.hotel_microservice.Entities.HotelMaster;
import com.example.hotel_microservice.Service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelMasterController {

    @Autowired
    IHotelService hotelService;

    @GetMapping("/hotels")
    public List<HotelMaster> getAllHotels(){
        List<HotelMaster> hotelMasterList = new ArrayList<>();
        hotelMasterList = hotelService.getHotelList();
        return hotelMasterList;
    }

    @GetMapping("/getHotelsByCityId/{cityid}")
    public List<HotelMaster> getHotelsByCityId(@PathVariable Integer cityid){
        System.out.println("Inside Hotel Service 1 for cityid: "+cityid);
        List<HotelMaster> hotelMasterList = new ArrayList<>();
        hotelMasterList = hotelService.getHotelByCityId(cityid);
        return hotelMasterList;
    }

    @GetMapping("/test")
    public HotelMaster justToTestFaultTolerance(){
        throw new RuntimeException("Error in Hotel Master Service");
    }
}
