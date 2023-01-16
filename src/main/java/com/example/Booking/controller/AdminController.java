package com.example.Booking.controller;
import com.example.Booking.entity.*;
import com.example.Booking.repository.RoomRepository;
import com.example.Booking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/Booking/Admin")
@CrossOrigin("http://localhost:4200")
public class AdminController {
    @Autowired
    AdminService adminService;

    @Autowired
    ClientService clientService;

    @Autowired
    ManagerService managerService;

  @Autowired
    RoleService roleService;
    @Autowired
    HotelService hotelService;
    @Autowired
     RoomRepository roomRepository;

    @Autowired
    RoomService roomService;
    /*Admin*/

    @GetMapping("/getAllAdmin")
    public List<Admin> getAllUser(){return adminService.getAllAdmin();}


    @GetMapping("/getAdminById/{id}")
    public Optional<Admin> getUserById(@PathVariable("id") Long id){ return  adminService.getAdminById(id);}

    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin ){return  adminService.addAdmin(admin);}
    /*Client*/
    @DeleteMapping("/deleteClientById/{id}")
   public Integer deleteClientById(@PathVariable("id") Long id){
       return clientService.deleteClientById(id);
   }
    @GetMapping("/getAllClient")
    public List<Client> getAllClient(){return clientService.getAllClient();}


    @GetMapping("/getClientById/{id}")
    public Optional<Client> getClientById(@PathVariable("id") Long id){ return  clientService.getClientById(id);}

    @PostMapping("/addClient")
    public Client addClient(@RequestBody Client client ){return  clientService.addClient(client);}


    @PutMapping("/updateClient")
    public  Client updateClient(@RequestBody Client client){
        return clientService.updateClient(client);
    }
    /*Manager*/

    @GetMapping("/getAllManger")
    public List<Manager> getAllManger(){return managerService.getAllManger();}

    @DeleteMapping("/deleteManagerById/{id}")
    public Integer deleteManagerById(@PathVariable("id") Long id){
        return managerService.deleteManagerById(id);
    }

    @PutMapping("/updateManager")
    public  Manager updateManager(@RequestBody Manager manager){
        return managerService.updateManager(manager);
    }

    @GetMapping("/getMangerById/{id}")
    public Optional<Manager> getMangerById(@PathVariable("id") Long id){ return  managerService.getMangerById(id);}

    @PostMapping("/addManger")
    public Manager addManger(@RequestBody Manager manger ){return  managerService.addManger(manger);}

    /*Hotel*/

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
    public  List<Hotel> getAllHotels(){
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
