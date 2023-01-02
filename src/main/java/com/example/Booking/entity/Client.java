package com.example.Booking.entity;
import com.example.Booking.util.Message;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Entity


public class Client extends  User{

    @Transient
    private Message message;

    public Message getMessage ( ) {
        return message;
    }

    public void setMessage ( Message message ) {
        this.message = message;
    }
}
