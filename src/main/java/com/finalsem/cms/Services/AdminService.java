package com.finalsem.cms.Services;

import com.finalsem.cms.repositories.AdminRepo;
import com.finalsem.cms.users.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminRepo adminRepo;

    public List<Admin> getAdmins(){
        return adminRepo.findAll();
    }

    public Admin getAdmin(int id) {
        return adminRepo.findById(id).get();
    }

    public void saveOrUpdateAdmin(Admin admin) {
        adminRepo.save(admin);
    }

    public void deleteAdmin(int id) {
        adminRepo.deleteById(id);
    }

    public int validateAdmin(String email,String password)
    {
        Admin a=adminRepo.findByEmailAndPassword(email, password);
        if(a!=null)
            return a.getAdminId();
        return -1;
    }
}
