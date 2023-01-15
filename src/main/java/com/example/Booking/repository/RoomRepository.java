package com.example.Booking.repository;

import com.example.Booking.entity.Hotel;
import com.example.Booking.entity.Room;
import com.example.Booking.entity.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {

    Optional<Room> findRoomByRoomNumber(Integer roomNumber);

    List<Room> findRoomByRoomStatus(RoomStatus roomStatus);




    List<Room> findRoomsByHotel(Hotel hotel);
}
