package com.example.Booking.entity;


import com.example.Booking.util.Message;
import jakarta.persistence.*;

@Entity
public class Room {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private Integer roomNumber;
    private float price;
    private Integer numberBeds;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private  Hotel hotel;
    private  RoomStatus roomStatus;

    public Room(Long id, Integer roomNumber,
                float price, Integer numberBeds,
                Hotel hotel, RoomStatus roomStatus) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.price = price;
        this.numberBeds = numberBeds;
        this.hotel = hotel;
        this.roomStatus = roomStatus;
    }


    public Room(Integer roomNumber, float price,
                Integer numberBeds, Hotel hotel,
                RoomStatus roomStatus) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.numberBeds = numberBeds;
        this.hotel = hotel;
        this.roomStatus = roomStatus;
    }

    public Room() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getNumberBeds() {
        return numberBeds;
    }

    public void setNumberBeds(Integer numberBeds) {
        this.numberBeds = numberBeds;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNumber=" + roomNumber +
                ", price=" + price +
                ", numberBeds=" + numberBeds +
                ", hotel=" + hotel +
                ", roomStatus=" + roomStatus +
                '}';
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
