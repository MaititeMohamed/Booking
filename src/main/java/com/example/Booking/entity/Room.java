package com.example.Booking.entity;


import com.example.Booking.util.Message;


import javax.persistence.*;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String roomType;
    private String description;
    private Integer roomNumber;
    private float price;
    private Integer numberBeds;
    private Integer capacity;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private  Hotel hotel;

    private  RoomStatus roomStatus;


    public Room(Long id, String roomType, String description, Integer roomNumber, float price, Integer numberBeds, Integer capacity, Hotel hotel, RoomStatus roomStatus, Message message) {
        this.id = id;
        this.roomType = roomType;
        this.description = description;
        this.roomNumber = roomNumber;
        this.price = price;
        this.numberBeds = numberBeds;
        this.capacity = capacity;
        this.hotel = hotel;
        this.roomStatus = roomStatus;
        this.message = message;
    }

    public Room(String roomType, String description, Integer roomNumber, float price, Integer numberBeds, Integer capacity, Hotel hotel, RoomStatus roomStatus, Message message) {
        this.roomType = roomType;
        this.description = description;
        this.roomNumber = roomNumber;
        this.price = price;
        this.numberBeds = numberBeds;
        this.capacity = capacity;
        this.hotel = hotel;
        this.roomStatus = roomStatus;
        this.message = message;

    }

    public Room() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
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
                ", roomType='" + roomType + '\'' +
                ", description='" + description + '\'' +
                ", roomNumber=" + roomNumber +
                ", price=" + price +
                ", numberBeds=" + numberBeds +
                ", capacity=" + capacity +
                ", hotel=" + hotel +
                ", roomStatus=" + roomStatus +
                ", message=" + message +
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
