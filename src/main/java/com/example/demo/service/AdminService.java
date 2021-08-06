package com.example.demo.service;

import com.example.demo.dao.AdminRepository;
import com.example.demo.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    public void addNewAdmin(Admin admin) {
        Optional<Admin> adminByEmail = adminRepository.
                findAdminByEmail(admin.getEmail());
        if(adminByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        adminRepository.save(admin);
    }

    public void deleteAdminById(Long id) {
        boolean exists = adminRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("admin with id " + id + " does not exists");
        }
        adminRepository.deleteById(id);
    }

    @Transactional
    public void updateAdmin(Long id, Admin adminUpdate) {
        Admin admin = adminRepository.findById(id).orElseThrow(()
                -> new IllegalStateException("admin with id " + id + " does not exists"));
        if(adminUpdate.getName() != null && adminUpdate.getName().length() > 0 && !Objects.equals(admin.getName(), adminUpdate.getName())) {
            admin.setName(adminUpdate.getName());
        }

        if(adminUpdate.getEmail() != null && adminUpdate.getEmail().length() > 0 && !Objects.equals(admin.getEmail(), adminUpdate.getEmail())) {
            admin.setEmail(adminUpdate.getEmail());
        }
    }
}
