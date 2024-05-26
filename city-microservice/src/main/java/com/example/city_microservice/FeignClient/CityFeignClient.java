package com.example.city_microservice.FeignClient;

import com.example.city_microservice.Entities.HotelMaster;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//@FeignClient(url = "${url.hotelbyid}",value = "city-feign-client")
//can also include path attribute for url path extension to "url" attribute
@FeignClient(value = "hotel-application", path="/getHotelsByCityId") //instead of url we will be calling service by name
public interface CityFeignClient {

    //We can directly access api of hotel service
    //get hotel list of a city id
    //${url.hotelbyid} + /{cityid} = http://localhost:8080/getHotelsByCityId/{cityid}
    @GetMapping("/{cityid}")
    public List<HotelMaster> getHotelByCityId(@PathVariable Integer cityid);
}
