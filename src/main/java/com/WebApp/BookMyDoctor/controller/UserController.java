package com.WebApp.BookMyDoctor.controller;

import com.WebApp.BookMyDoctor.Entity.User;
import com.WebApp.BookMyDoctor.Entity.enums;
import com.WebApp.BookMyDoctor.config.ApiResponse;
import com.WebApp.BookMyDoctor.dto.UserRequestDto;
import com.WebApp.BookMyDoctor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody UserRequestDto dto) {
        User user = service.registerUser(dto);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "user registered SuccessFully", user));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestParam String email
            , @RequestParam String password
            , @RequestParam enums.Role role) {

        return ResponseEntity.ok(new ApiResponse <>(HttpStatus.FOUND, "Login SuccessFull", service.login(email, password, role)));
    }

    @GetMapping("alldoctors")
    public List<User> finaAll() {
        return service.getAllDoctors();
    }

    @GetMapping("/search/{search}")
    public List<User> findByLocationAndSpecialization( @PathVariable String search) {
        return service.searchDoctorByLocationOrSpecialization( search);
    }
}
