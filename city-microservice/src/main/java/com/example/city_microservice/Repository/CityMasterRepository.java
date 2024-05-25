package com.example.city_microservice.Repository;

import com.example.city_microservice.Entities.CityMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityMasterRepository extends JpaRepository<CityMaster, Integer> {
}
