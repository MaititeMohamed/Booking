package com.example.Booking.controller;

import com.example.Booking.entity.Hotel;
import com.example.Booking.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path = "/Booking/Manger")
public class ManagerController {


    @Autowired
    ManagerService managerService;


    @PostMapping("/addHotel")
    public Hotel addHotel(@RequestBody Hotel hotel ){return  managerService.addHotel(hotel);}


}
