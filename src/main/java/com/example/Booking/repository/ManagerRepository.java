package com.example.Booking.repository;


import com.example.Booking.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager,Long> {
    Optional<Manager> findMangerByEmail(String email);
}
