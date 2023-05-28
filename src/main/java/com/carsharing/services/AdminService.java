package com.carsharing.services;

import com.carsharing.models.Admin;
import com.carsharing.repositories.AdminRepository;
import com.carsharing.validators.AdminValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepository;
    private final AdminValidator adminValidator;

    public AdminService(
        AdminRepository adminRepository,
        AdminValidator adminValidator
    ) {
        this.adminRepository = adminRepository;
        this.adminValidator = adminValidator;
    }

    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    public Admin findById(long id) {
        adminValidator.validate(id, adminRepository.findAll());
        return adminRepository.findById(id).orElseThrow();
    }

    public Admin save(Admin admin) {
        adminValidator.validate(admin, adminRepository.findAll());
        adminRepository.save(admin);
        return admin;
    }

    public Admin update(long id, Admin admin) {
        adminValidator.validate(id, adminRepository.findAll());
        adminRepository.update(id, admin);
        return admin;
    }

    public void delete(long id) {
        adminValidator.validate(id, adminRepository.findAll());
        adminRepository.delete(id);
    }

    public Admin findByEmail(String email) {
        adminValidator.validate(email, adminRepository.findAll());
        return adminRepository.findByEmail(email).orElseThrow();
    }
}
