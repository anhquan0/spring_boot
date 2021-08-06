package com.example.demo.controller;

import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Admin;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<Admin> getAdmins() {
        return adminService.getAdmins();
    }

    @PostMapping
    public void registerNewAdmin(@RequestBody Admin admin) {
        adminService.addNewAdmin(admin);
    }

    @DeleteMapping(path = "{id}")
    public void deleteAdmin(@PathVariable("id") Long id) {
        adminService.deleteAdminById(id);
    }

    @PutMapping(path = "{id}")
    public void updateAdmin(@PathVariable("id") Long id, @RequestBody Admin admin) {
        adminService.updateAdmin(id, admin);
    }
}
