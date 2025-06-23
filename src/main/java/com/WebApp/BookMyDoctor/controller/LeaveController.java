package com.WebApp.BookMyDoctor.controller;

import com.WebApp.BookMyDoctor.Entity.LeaveRequest;
import com.WebApp.BookMyDoctor.config.ApiResponse;
import com.WebApp.BookMyDoctor.dto.LeavesDto;
import com.WebApp.BookMyDoctor.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaves")
public class    LeaveController {

    @Autowired
    private LeaveService service;

    @PostMapping("/apply")
    public ResponseEntity<ApiResponse> leaves(@RequestBody LeavesDto dto)
    {
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK,"LeaveApplied", service.apply(dto)));
    }
    @GetMapping("/leavelist/{id}")
    public List<LeaveRequest> leaveList(@PathVariable Long id)
    {
        return service.allLeaves(id);
    }
}
