package com.example.Booking.entity;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
public class Reservation {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private LocalDate startDate;
    private  LocalDate endDate;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private  Client client;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private  Room room;

    private  ReservationStatus reservationStatus;


}
