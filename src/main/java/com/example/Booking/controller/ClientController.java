package com.example.Booking.controller;


import com.example.Booking.entity.Room;
import com.example.Booking.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/Booking/Client")
public class ClientController {

    @Autowired
    ClientService clientService;


    @GetMapping("/getActiveRooms")
    public List<Room>  getActiveRooms(){
        return  clientService.getActiveRooms();
    }

}
