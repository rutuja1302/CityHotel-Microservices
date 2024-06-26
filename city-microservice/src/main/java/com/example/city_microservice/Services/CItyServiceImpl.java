package com.example.city_microservice.Services;

import com.example.city_microservice.Entities.CityMaster;
import com.example.city_microservice.Entities.CityResponse;
import com.example.city_microservice.Entities.HotelMaster;
import com.example.city_microservice.FeignClient.CityFeignClient;
import com.example.city_microservice.Repository.CityMasterRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class CItyServiceImpl implements ICityService{
    Logger logger = LogManager.getLogger(CItyServiceImpl.class);

    int count = 1;

    @Autowired
    CityMasterRepository cityMasterRepository;

    @Autowired
    RestTemplate restTemplate;

    @Value("${url.hotelbyid}")
    private String serviceUrl;

    @Autowired
    CityFeignClient cityFeignClient;

    @Override
    public List<CityMaster> getAllCities() {
        return cityMasterRepository.findAll();
    }

    @Override
    public List<CityResponse> getAllHotelsInCities() {
        List<CityResponse> cityResponseList = new ArrayList<>();
        //Get All Cities
        List<CityMaster> cityMasters = cityMasterRepository.findAll();

        //Get corresponding hotels for each city
        cityMasters.forEach(i -> {
            List<HotelMaster> hotels = getHotelsByCityId(i.getCityid());
            CityResponse cityResponse = new CityResponse();
            cityResponse.setCityid(i.getCityid());
            cityResponse.setCityname(i.getCityname());
            cityResponse.setHotelMaster(hotels);

            cityResponseList.add(cityResponse);
        });
        return cityResponseList;
    }

    @Override
    public List<HotelMaster> getHotelsForCityId(Integer cityid) {
        List<HotelMaster> cityResponseList = new ArrayList<>();
        cityResponseList = cityFeignClient.getHotelByCityId(cityid);
        return  cityResponseList;
    }

    @Override
    @CircuitBreaker(name = "hotelService", fallbackMethod = "getDummyHotel")
    public HotelMaster test() {
        logger.info("count: "+count);
        count++;
        return cityFeignClient.justToTestFaultTolerance();
    }

    public HotelMaster getDummyHotel(Throwable throwable) {
        logger.error("In Fallback method");
        return new HotelMaster(1,"Dummy",2);
    }

    public List<HotelMaster> getHotelsByCityId(Integer cityid){
        List<HotelMaster> hotellist = new ArrayList<>();
        String url = serviceUrl+cityid;
        hotellist = restTemplate.getForObject(url, List.class);
        return  hotellist;
    }
}
