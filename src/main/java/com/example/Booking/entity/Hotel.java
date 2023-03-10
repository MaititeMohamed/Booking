package com.example.Booking.entity;

import com.example.Booking.util.Message;


import javax.persistence.*;

@Entity
@Table(name = "hotel")
public class Hotel {
    // I add User prop  just for DefaultData
    @Transient
    @ManyToOne
    @JoinColumn(name = "user_id")
    private  User User ;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String hotelName;
    @Enumerated(EnumType.STRING)
    private  Status  status;
    private  String address;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;
    private  String country;
    private  String city;

    public Hotel(Long id, String hotelName, Status status,
                 String address, Manager manager,
                 String country, String city) {
        this.id = id;
        this.hotelName = hotelName;
        this.status = status;
        this.address = address;
        this.manager = manager;
        this.country = country;
        this.city = city;
    }

    public Hotel(String hotelName, Status status,
                 String address, Manager manager,
                 String country, String city) {
        this.hotelName = hotelName;
        this.status = status;
        this.address = address;
        this.manager = manager;
        this.country = country;
        this.city = city;
    }

    public Hotel() {
    }

    public Hotel(String hotelName, Status status, String address, User user, String country, String city) {
        this.hotelName = hotelName;
        this.status = status;
        this.address = address;
        this.User = user;
        this.country = country;
        this.city = city;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManger(Manager manager) {
        this.manager = manager;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", hotelName='" + hotelName + '\'' +
                ", status=" + status +
                ", address='" + address + '\'' +
                ", manager=" + manager +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
    @Transient
    private Message message;

    public com.example.Booking.entity.User getUser() {
        return User;
    }

    public void setUser(com.example.Booking.entity.User User) {
        this.User = User;
    }

    public Message getMessage ( ) {
        return message;
    }

    public void setMessage ( Message message ) {
        this.message = message;
    }
}