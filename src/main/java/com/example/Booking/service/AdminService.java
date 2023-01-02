package com.example.Booking.service;
import com.example.Booking.entity.Admin;
import com.example.Booking.entity.Status;
import com.example.Booking.repository.AdminRepository;
import com.example.Booking.repository.RoleRepository;
import com.example.Booking.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
     @Autowired
    AdminRepository adminRepository;

     @Autowired
     RoleRepository roleRepository;

    public List<Admin> getAllAdmin(){return  adminRepository.findAll();}
    public Optional<Admin> getAdminById(Long id){
        return adminRepository.findById(id);
    }
    public Optional<Admin> getAdminByEmail(String email){
        return adminRepository.findAdminByEmail(email);
    }



    public Admin addAdmin(Admin admin){
        Message message =new Message();
        Optional<Admin> adminByEmail=getAdminByEmail(admin.getEmail());
        if(admin.getEmail()==null || admin.getFirstName()==null
                || admin.getLastName()==null ||admin.getPassword()==null
        ){
            message.setState("Error");
            message.setMessage("Pleas Insert all information");
            admin.setMessage(message);
            return  admin;
        }

        if(adminByEmail.isPresent()){
            message.setState("Error");
            message.setMessage("This Admin is Already exist");
            admin.setMessage(message);
            return  admin;
        }

        message.setState("Success");
        message.setMessage("Admin has ben created");
        admin.setMessage(message);

      admin.setRole(roleRepository.getRoleByRoleName("Admin"));
        admin.setStatus(Status.ACTIVE);
        adminRepository.save(admin);
        return admin;
    }

}
