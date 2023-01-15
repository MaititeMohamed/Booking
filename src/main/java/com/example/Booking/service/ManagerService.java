package com.example.Booking.service;


import com.example.Booking.entity.*;
import com.example.Booking.repository.HotelRepository;
import com.example.Booking.repository.ManagerRepository;
import com.example.Booking.repository.RoleRepository;
import com.example.Booking.repository.RoomRepository;
import com.example.Booking.util.Message;
import jakarta.transaction.Transactional;
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
    @Autowired
    private RoomRepository roomRepository;

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

    public Optional<Room> findRoomByRoomNumber(Integer roomNumber){
        return  roomRepository.findRoomByRoomNumber(roomNumber);
    }

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

    @Transactional
    public Hotel updateHotel(Hotel hotel){
        Message message = new Message();
        Optional<Hotel> hotelByName=getHotelByHotelName(hotel.getHotelName());
        Hotel hotelupdate=hotelByName.get();
        if(hotelupdate.getHotelName()==null ||hotelupdate.getAddress()==null
                ||hotelupdate.getCity()==null ||hotelupdate.getCountry()==null ){
            message.setState("Error");
            message.setMessage("Pleas Insert all information");
            hotel.setMessage(message);
            return  hotelupdate;
        }
        if(hotelByName.isPresent()){


        message.setState("success");
        message.setMessage("hotel has ben created ");
            hotelupdate.setMessage(message);
            hotelupdate.setHotelName(hotel.getHotelName());
            hotelupdate.setAddress(hotel.getAddress());
            hotelupdate.setCity(hotel.getCity());
            hotelupdate.setAddress(hotel.getCountry());
            hotelupdate.setStatus(Status.DEACTIVATE);
            hotelupdate.setManger(getMangerById(1L).get());

         return hotelupdate;
        }
        return hotelupdate;
    }
    public Room addRoomToHotel(Room room){

        Message message = new Message();
        Optional<Room> findRoomNumber=findRoomByRoomNumber(room.getRoomNumber());
        if(room.getRoomNumber()==null  || room.getNumberBeds()==null
        ||room.getPrice() == 0 ){
            message.setState("Error");
            message.setMessage("Pleas Insert all information");
            room.setMessage(message);
            return  room;
        }
        if(findRoomNumber.isPresent()){
            message.setState("Error");
            message.setMessage("This room is Already exist");
            room.setMessage(message);
            return  room;
        }
        message.setState("success");
        message.setMessage("hotel has ben created ");
        room.setMessage(message);
        room.setRoomStatus(RoomStatus.AVAILABLE);
        room.setHotel(hotelRepository.findById(1L).get());
       Room room1= roomRepository.save(room);
        return room1;
    }


    public Integer deleteManagerById(Long id){
        boolean exists =managerRepository.existsById(id);
        if(!exists){
            return  -1;
        }else {

            try {
                managerRepository.deleteById(id);
                return 1;
            } catch (Exception e){
                return 0;
            }
        }
    }


    @Transactional
    public Manager updateManager(Manager manager){
        Message message =new Message();
        Optional<Manager> managerByEmail=getMangerByEmail(manager.getEmail());
        Manager managerupdate=managerByEmail.get();
        if(managerupdate.getEmail()==null || managerupdate.getFirstName()==null
                || managerupdate.getLastName()==null ||managerupdate.getPassword()==null
        ){
            message.setState("Error");
            message.setMessage("Pleas Insert all information");
            managerupdate.setMessage(message);
            return  managerupdate;
        }
        if(managerByEmail.isPresent()){
            message.setState("Success");
            message.setMessage("Manager has ben updated");
            managerupdate.setMessage(message);
            managerupdate.setFirstName(manager.getFirstName());
            managerupdate.setLastName(manager.getLastName());
            managerupdate.setEmail(manager.getEmail());
            managerupdate.setPassword(manager.getPassword());
            managerupdate.setRole(roleRepository.getRoleByRoleName("Manager"));
            managerupdate.setStatus(Status.ACTIVE);
            return managerupdate;
        }

        return  managerupdate;
    }

}
