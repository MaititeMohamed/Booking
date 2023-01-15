package com.example.Booking.service;

import com.example.Booking.entity.Hotel;
import com.example.Booking.entity.Room;
import com.example.Booking.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
      RoomRepository roomRepository;



    public List<Room> getRoomsByHotel(Hotel hotel){
        return  roomRepository.findRoomsByHotel(hotel);
    }


}
