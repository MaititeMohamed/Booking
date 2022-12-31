package com.example.Booking.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private  String hotelName;
    private  Status  status;
    private  String address;
    @ManyToOne
    @JoinColumn(name = "manger_id")
    private  Manger manger;
    private  String country;
    private  String city;

    public Hotel(Long id, String hotelName, Status status,
                 String address, Manger manger,
                 String country, String city) {
        this.id = id;
        this.hotelName = hotelName;
        this.status = status;
        this.address = address;
        this.manger = manger;
        this.country = country;
        this.city = city;
    }

    public Hotel(String hotelName, Status status,
                 String address, Manger manger,
                 String country, String city) {
        this.hotelName = hotelName;
        this.status = status;
        this.address = address;
        this.manger = manger;
        this.country = country;
        this.city = city;
    }

    public Hotel() {
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

    public Manger getManger() {
        return manger;
    }

    public void setManger(Manger manger) {
        this.manger = manger;
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
                ", manger=" + manger +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}