package com.example.Booking.repository;

import com.example.Booking.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {

    Optional<Room> findRoomByRoomNumber(Integer roomNumber);
}
