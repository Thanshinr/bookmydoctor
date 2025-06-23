package com.WebApp.BookMyDoctor.service;

import com.WebApp.BookMyDoctor.Entity.User;
import com.WebApp.BookMyDoctor.Entity.enums;
import com.WebApp.BookMyDoctor.config.ApiResponse;
import com.WebApp.BookMyDoctor.dto.UserRequestDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

        User registerUser(UserRequestDto dto);
        List<User> getAllDoctors();
        List<User> searchDoctorByLocationOrSpecialization(String search);
        Optional<User> login(String email, String passWord, enums.Role role);
}
