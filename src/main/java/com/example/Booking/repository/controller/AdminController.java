package com.example.Booking.repository.controller;
import com.example.Booking.entity.*;
import com.example.Booking.service.AdminService;
import com.example.Booking.service.ClientService;
import com.example.Booking.service.HotelService;
import com.example.Booking.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/Booking/Admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @Autowired
    ClientService clientService;

    @Autowired
    ManagerService managerService;


    @Autowired
    HotelService hotelService;
    /*Admin*/

    @GetMapping("/getAllAdmin")
    public List<Admin> getAllUser(){return adminService.getAllAdmin();}


    @GetMapping("/getAdminById/{id}")
    public Optional<Admin> getUserById(@PathVariable("id") Long id){ return  adminService.getAdminById(id);}

    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin ){return  adminService.addAdmin(admin);}
    /*Client*/


    @GetMapping("/getAllClient")
    public List<Client> getAllClient(){return clientService.getAllClient();}


    @GetMapping("/getClientById/{id}")
    public Optional<Client> getClientById(@PathVariable("id") Long id){ return  clientService.getClientById(id);}

    @PostMapping("/addClient")
    public Client addClient(@RequestBody Client client ){return  clientService.addClient(client);}

    /*Manager*/

    @GetMapping("/getAllManger")
    public List<Manager> getAllManger(){return managerService.getAllManger();}


    @GetMapping("/getMangerById/{id}")
    public Optional<Manager> getMangerById(@PathVariable("id") Long id){ return  managerService.getMangerById(id);}

    @PostMapping("/addManger")
    public Manager addManger(@RequestBody Manager manger ){return  managerService.addManger(manger);}

    /*Hotel*/

    @PutMapping ("/activeHotel/{id}")
    public Hotel activeHotel(@PathVariable  Long id){
      return    hotelService.activeHotel(id);
    }



}
