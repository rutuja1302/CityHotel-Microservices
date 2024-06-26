package com.example.hotel_microservice.Repository;

import com.example.hotel_microservice.Entities.HotelMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelMasterRepository extends JpaRepository<HotelMaster,Integer> {
    List<HotelMaster> findByCityid(Integer cityid);
}
