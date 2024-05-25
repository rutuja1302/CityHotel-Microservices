package com.example.hotel_microservice.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "hotelmaster", schema = "public")
@Data
public class HotelMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hotelid;
    private String hotelname;
    private Integer cityid;
}
