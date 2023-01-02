package com.example.Booking.entity;

import com.example.Booking.util.Message;
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

    public Reservation(Long id, LocalDate startDate, LocalDate endDate, Client client, Room room, ReservationStatus reservationStatus) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
        this.room = room;
        this.reservationStatus = reservationStatus;
    }

    public Reservation(LocalDate startDate, LocalDate endDate, Client client, Room room, ReservationStatus reservationStatus) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
        this.room = room;
        this.reservationStatus = reservationStatus;
    }

    public Reservation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    @Transient
    private Message message;

    public Message getMessage ( ) {
        return message;
    }

    public void setMessage ( Message message ) {
        this.message = message;
    }
}
