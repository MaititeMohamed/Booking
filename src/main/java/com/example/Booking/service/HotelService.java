package com.example.Booking.service;

import com.example.Booking.entity.Hotel;
import com.example.Booking.entity.Status;
import com.example.Booking.repository.HotelRepository;
import com.example.Booking.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HotelService {


    @Autowired
    HotelRepository hotelRepository ;



    public Hotel activeHotel( Long id){
        Optional<Hotel> hotelOptional = hotelRepository.findById(id);

        if (hotelOptional.isPresent() && hotelOptional.get().getStatus() == Status.DEACTIVATE){
            hotelOptional.get().setStatus(Status.ACTIVE);
            hotelRepository.save(hotelOptional.get());
            return hotelOptional.get();
        }else {
            return  null;
        }

    }

}
