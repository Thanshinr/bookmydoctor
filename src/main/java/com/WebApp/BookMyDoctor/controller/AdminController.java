package com.WebApp.BookMyDoctor.controller;

import com.WebApp.BookMyDoctor.Entity.LeaveRequest;
import com.WebApp.BookMyDoctor.Entity.enums;
import com.WebApp.BookMyDoctor.config.ApiResponse;
import com.WebApp.BookMyDoctor.dto.LeavesDto;
import com.WebApp.BookMyDoctor.dto.UserRequestDto;
import com.WebApp.BookMyDoctor.service.LeaveService;
import com.WebApp.BookMyDoctor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService user;
    @Autowired
    private LeaveService leave;


    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody UserRequestDto dto) {
        return new ResponseEntity(user.registerUser(dto), HttpStatus.IM_USED);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestParam String email,
                                             @RequestParam String password,
                                             @RequestParam enums.Role r) {
        return ResponseEntity
                .ok(new ApiResponse(HttpStatus.FOUND, "Login SuccessFully",user.login(email, password, r)));
    }

    @GetMapping("/leavelist/{id}")
    public List<LeaveRequest> list(@PathVariable Long id) {
        return leave.allLeaves(id);
    }

    @PostMapping("/approval")
    public ResponseEntity<ApiResponse> approval(@RequestBody LeavesDto status) {
        return ResponseEntity
                .ok(new ApiResponse(HttpStatus.ACCEPTED, "LeaveApproved", leave.approval(status)));
    }

}
