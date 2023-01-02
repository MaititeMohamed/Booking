package com.example.Booking.controller;
import com.example.Booking.entity.Admin;
import com.example.Booking.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/Booking/Admin")
public class AdminController {
    @Autowired
    AdminService adminService;



    @GetMapping("/getAllAdmin")
    public List<Admin> getAllUser(){return adminService.getAllAdmin();}


    @GetMapping("/getAdminById/{id}")
    public Optional<Admin> getUserById(@PathVariable("id") Long id){ return  adminService.getAdminById(id);}

    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin ){return  adminService.addAdmin(admin);}

}
