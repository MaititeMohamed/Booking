package com.example.Booking.repository;

import org.apache.catalina.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository  extends JpaRepository<Manager,Long> {
}
