package com.example.Booking.service;

import com.example.Booking.entity.Role;
import com.example.Booking.repository.RoleRepository;
import com.example.Booking.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;




    public List<Role> getAllRole(){return  roleRepository.findAll();}

    public Role getRoleByName(String roleName){
        return  roleRepository.getRoleByRoleName(roleName);
    }

    public Role addRole(Role role){
        Message message =new Message();
        Optional<Role> roleName = Optional.ofNullable(getRoleByName(role.getRoleName()));

        if(role.getRoleName()==null || role.getRoleName()==""){
           message.setState("Error");
           message.setMessage("Please Insert the Role Name ");
           role.setMessage(message);
           return role;
        }
        if(roleName.isPresent()){
            message.setState("Error");
            message.setMessage("this role already exists");
            role.setMessage(message);
            return role;
        }

        message.setState ( "Success" );
        message.setMessage ( "Role has ben created" );
        role.setMessage(message);
        roleRepository.save(role);
        return role;
    }
}
