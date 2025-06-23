package com.WebApp.BookMyDoctor.service;

import com.WebApp.BookMyDoctor.Entity.User;
import com.WebApp.BookMyDoctor.Entity.enums;
import com.WebApp.BookMyDoctor.dto.UserRequestDto;
import com.WebApp.BookMyDoctor.exception.LoginException;
import com.WebApp.BookMyDoctor.exception.UserExistException;
import com.WebApp.BookMyDoctor.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public User registerUser(UserRequestDto dto) {
        Optional<User> user = userRepository.findByEmail(dto.getEmail());
        if (user.isPresent()) {
            throw new UserExistException("User Already Registered ");
        } else {
            User user1 = modelMapper.map(dto, User.class);
            User saved = userRepository.save(user1);
            System.out.println("User registered" + saved.getId());
            return saved;
        }
    }

    @Override
    public List<User> getAllDoctors() {
        return userRepository.findByRole(enums.Role.DOCTOR);
    }

    @Override
    public List<User> searchDoctorByLocationOrSpecialization(String search) {
        System.out.println("searching doctor by location");
        return userRepository.findByLocationOrSpecialization(search);
    }

    @Override
    public Optional<User> login(String email, String password, enums.Role role) {


        Optional<User> user = userRepository.findByEmailAndPasswordAndRole(email, password, role);
        if (user.isEmpty()) throw new LoginException("Invalid User Credentials");
        else return user;
    }
}
