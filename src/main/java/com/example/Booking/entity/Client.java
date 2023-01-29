package com.example.Booking.entity;
import com.example.Booking.util.Message;


import javax.persistence.*;

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
