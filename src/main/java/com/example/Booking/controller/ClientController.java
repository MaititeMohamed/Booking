package com.example.Booking.controller;

import com.example.Booking.entity.Client;
import com.example.Booking.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/Booking/Client")
public class ClientController {
        @Autowired
    ClientService clientService;

    @GetMapping("/getAllClient")
    public List<Client> getAllClient(){return clientService.getAllClient();}


    @GetMapping("/getClientById/{id}")
    public Optional<Client> getClientById(@PathVariable("id") Long id){ return  clientService.getClientById(id);}

    @PostMapping("/addClient")
    public Client addClient(@RequestBody Client client ){return  clientService.addClient(client);}
}
