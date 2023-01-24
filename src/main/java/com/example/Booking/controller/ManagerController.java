package com.example.Booking.controller;

import com.example.Booking.entity.Hotel;
import com.example.Booking.entity.Room;
import com.example.Booking.service.HotelService;
import com.example.Booking.service.ManagerService;
import com.example.Booking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/Booking/Manager")
@CrossOrigin("http://localhost:4200")
public class ManagerController {


    @Autowired
    ManagerService managerService;

    @Autowired
    HotelService hotelService;
    @Autowired
    RoomService roomService;

    @PostMapping("/addHotel")
    public Hotel addHotel(@RequestBody Hotel hotel ){return  managerService.addHotel(hotel);}


    @PostMapping("/addRoom")
    public Room addRomToHotel(@RequestBody Room room){

        return managerService.addRoomToHotel(room);
    }

    @PutMapping ("/activeHotel/{id}")
    public Hotel activeHotel(@PathVariable  Long id){
        return    hotelService.activeHotel(id);
    }

    @DeleteMapping("/deleteHotelById/{id}")
    public Integer deleteHotelById(@PathVariable("id") Long id){
        return hotelService.deleteHotelById(id);
    }

    @PutMapping("/updateHotel")
    public  Hotel updateManager(@RequestBody Hotel hotel){
        return managerService.updateHotel(hotel);
    }
    @GetMapping("/getAllHotels")
    public List<Hotel> getAllHotels(){
        return hotelService.getAllHotels();
    }
    @GetMapping("/getHotelById/{id}")
    public Optional<Hotel> getHotelById(@PathVariable Long id){
        return hotelService.getHotelById(id);
    }

    /*Room*/
    @GetMapping("/getRoomsByHotelId/{hotel}")
    public  List<Room> getRoomsByHotel(@PathVariable Hotel hotel){

        return  roomService.getRoomsByHotel(hotel);
    }

    @GetMapping(path = "/getAllRoms")
    public List<Room> getAllRoom(){
        return  roomService.getAllRoms();
    }
    @DeleteMapping("/deleteRoomById/{id}")
    public Integer deleteRoomById(@PathVariable("id") Long id){
        return managerService.deleteRoomById(id);
    }

    @PutMapping("/updateRoom")
    public  Room updateRoom(@RequestBody Room  room){
        return managerService.updateRoomToHotel(room);
    }
    @GetMapping(path = "/getRoomById/{id}")
    public Optional<Room> getRoomById(@PathVariable("id") long id){
        return  roomService.getRoomById(id);
    }

}
