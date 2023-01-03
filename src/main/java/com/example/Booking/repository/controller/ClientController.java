package com.example.Booking.repository.controller;


import com.example.Booking.entity.Reservation;
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

    @PostMapping("/clientReservation")
    public Reservation clientReservation(@RequestBody Reservation reservation){

        return clientService.clientReservation(reservation);
    }

}
