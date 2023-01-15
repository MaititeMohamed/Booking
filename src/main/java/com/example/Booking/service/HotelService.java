package com.example.Booking.service;

import com.example.Booking.entity.Client;
import com.example.Booking.entity.Hotel;
import com.example.Booking.entity.Status;
import com.example.Booking.repository.HotelRepository;
import com.example.Booking.util.Message;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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


    public List<Hotel>  getAllHotels(){
        return  hotelRepository.findAll();
    }


    public Optional<Hotel> getHotelById(Long id){
        return  hotelRepository.findById(id);
    }

    public Integer deleteHotelById(Long id){
        boolean exists =hotelRepository.existsById(id);
        if(!exists){
            return  -1;
        }else {

            try {
                hotelRepository.deleteById(id);
                return 1;
            } catch (Exception e){
                return 0;
            }
        }
    }




}
