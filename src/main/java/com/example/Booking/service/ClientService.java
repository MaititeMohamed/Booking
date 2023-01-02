package com.example.Booking.service;
import com.example.Booking.entity.Client;
import com.example.Booking.entity.Room;
import com.example.Booking.entity.RoomStatus;
import com.example.Booking.entity.Status;
import com.example.Booking.repository.ClientRepository;
import com.example.Booking.repository.RoleRepository;
import com.example.Booking.repository.RoomRepository;
import com.example.Booking.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClientService {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    private RoomRepository roomRepository;

    public List<Client> getAllClient(){return  clientRepository.findAll();}
    public Optional<Client> getClientById(Long id){
        return clientRepository.findById(id);
    }
    public Optional<Client> getClientByEmail(String email){
        return clientRepository.findClientByEmail(email);
    }


    public List<Room> getActiveRooms(){
        return  roomRepository.findRoomByRoomStatus(RoomStatus.AVAILABLE);
    }


    public Client addClient(Client  client){
        Message message =new Message();
        Optional<Client> clientByEmail=getClientByEmail(client.getEmail());
        if(client.getEmail()==null || client.getFirstName()==null
                || client.getLastName()==null ||client.getPassword()==null
        ){
            message.setState("Error");
            message.setMessage("Pleas Insert all information");
            client.setMessage(message);
            return  client;
        }

        if(clientByEmail.isPresent()){
            message.setState("Error");
            message.setMessage("This User is Already exist");
            client.setMessage(message);
            return  client;
        }

        message.setState("Success");
        message.setMessage("Client has ben created");
        client.setMessage(message);

        client.setRole(roleRepository.getRoleByRoleName("Client"));
        client.setStatus(Status.ACTIVE);
        clientRepository.save(client);
        return client;
    }


}
