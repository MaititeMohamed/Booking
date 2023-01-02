package com.example.Booking.repository;

import com.example.Booking.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {
    Optional<Hotel> findHotelByHotelName(String hotelName);


}
