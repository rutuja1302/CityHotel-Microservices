package com.example.hotel_microservice.Service.Implementation;

import com.example.hotel_microservice.Entities.HotelMaster;
import com.example.hotel_microservice.Repository.HotelMasterRepository;
import com.example.hotel_microservice.Service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements IHotelService {

    @Autowired
    HotelMasterRepository hotelMasterRepository;

    @Override
    public List<HotelMaster> getHotelList() {
        return hotelMasterRepository.findAll();
    }
}
