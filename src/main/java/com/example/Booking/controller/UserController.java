package com.example.Booking.controller;



import com.example.Booking.entity.User;
import com.example.Booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path = "/Booking/User")
@CrossOrigin("http://localhost:4200")
public class UserController {

 @Autowired
    UserService userService;
 @GetMapping("/getUserByEmail/{email}")
    public User getUserByEmail(@PathVariable("email") String email){
        return userService.getUserByEmail(email);
    }


}
