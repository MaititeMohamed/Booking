package com.example.Booking.service;


import com.example.Booking.entity.*;
import com.example.Booking.repository.HotelRepository;
import com.example.Booking.repository.ManagerRepository;
import com.example.Booking.repository.RoleRepository;
import com.example.Booking.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ManagerRepository managerRepository;
    public List<Manager> getAllManger(){return  managerRepository.findAll();}
    public Optional<Manager> getMangerById(Long id){
        return managerRepository.findById(id);
    }
    public Optional<Manager> getMangerByEmail(String email){
        return managerRepository.findMangerByEmail(email);
    }



    public Manager addManger(Manager manger){
        Message message =new Message();
        Optional<Manager> mangerByEmail=getMangerByEmail(manger.getEmail());
        if(manger.getEmail()==null ||  manger.getFirstName()==null
         || manger.getLastName()==null ||manger.getPassword()==null
        ){
            message.setState("Error");
            message.setMessage("Pleas Insert all information");
            manger.setMessage(message);
            return  manger;
        }

        if(mangerByEmail.isPresent()){
            message.setState("Error");
            message.setMessage("This manger is Already exist");
            manger.setMessage(message);
            return  manger;
        }

        message.setState("Success");
        message.setMessage("manger has ben created");
        manger.setMessage(message);

        manger.setRole(roleRepository.getRoleByRoleName("Manager"));
        manger.setStatus(Status.ACTIVE);
        managerRepository.save(manger);
        return manger;
    }

    public Optional<Hotel> getHotelByHotelName(String hotelName){
        return  hotelRepository.findHotelByHotelName(hotelName);}

    public Hotel addHotel(Hotel hotel){
        Message message = new Message();
        Optional<Hotel> hotelByName=getHotelByHotelName(hotel.getHotelName());
        if(hotel.getHotelName()==null ||hotel.getAddress()==null
        ||hotel.getCity()==null ||hotel.getCountry()==null ){
            message.setState("Error");
            message.setMessage("Pleas Insert all information");
            hotel.setMessage(message);
            return  hotel;
        }
        if(hotelByName.isPresent()){
            message.setState("Error");
            message.setMessage("This hotel is Already exist");
            hotel.setMessage(message);
            return  hotel;
        }

        message.setState("success");
        message.setMessage("hotel has ben created ");
        hotel.setMessage(message);
        hotel.setStatus(Status.DEACTIVATE);
        hotel.setManger(getMangerById(1L).get());
       Hotel hotel1=  hotelRepository.save(hotel);
         return hotel1;
    }


    public Room addRoomToHotel(Room room){

        return room;
    }
}
