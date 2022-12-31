package com.example.Booking.controller;


import com.example.Booking.entity.Role;
import com.example.Booking.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Booking/Role")
public class RoleController {

    @Autowired
    RoleService roleService;
    @GetMapping("/getAllRole")
    @ResponseBody
    public List<Role> getAllRole(){return  roleService.getAllRole();}


    @PostMapping("/addRole")
    public  Role addRole(@RequestBody Role role){
        return  roleService.addRole(role);
    }
}
