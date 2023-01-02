package com.example.Booking.repository;
import com.example.Booking.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    Optional<Client> findClientByEmail(String email);
}
