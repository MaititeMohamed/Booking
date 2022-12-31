package com.example.Booking.service;

import com.example.Booking.entity.Role;
import com.example.Booking.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;




    public List<Role> getAllRole(){return  roleRepository.findAll();}

    public Role getRoleByName(String roleName){
        return  roleRepository.getRoleByName(roleName);
    }

    public Role addRole(Role role){





    return  role;
    }
}
