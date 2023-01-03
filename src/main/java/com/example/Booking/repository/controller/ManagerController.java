package com.example.Booking.repository.controller;

import com.example.Booking.entity.Hotel;
import com.example.Booking.entity.Room;
import com.example.Booking.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path = "/Booking/Manager")
public class ManagerController {


    @Autowired
    ManagerService managerService;



    @PostMapping("/addHotel")
    public Hotel addHotel(@RequestBody Hotel hotel ){return  managerService.addHotel(hotel);}


    @PostMapping("/addRoom")
    public Room addRomToHotel(@RequestBody Room room){

        return managerService.addRoomToHotel(room);
    }

}
