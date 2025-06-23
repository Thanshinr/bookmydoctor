package com.WebApp.BookMyDoctor.controller;

import com.WebApp.BookMyDoctor.Entity.Appointment;
import com.WebApp.BookMyDoctor.config.ApiResponse;
import com.WebApp.BookMyDoctor.dto.AppointmentDto;
import com.WebApp.BookMyDoctor.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired private AppointmentService service;

    @PostMapping("/book")
    public ResponseEntity<ApiResponse> book(@RequestBody AppointmentDto dto)
    {
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK ,"Appointment Booked", service.book(dto)));
    }
    @GetMapping("/patientappointment/{id}")
    public List<Appointment> patientList(@PathVariable Long id)
    {
        return service.getByPatient(id);
    }
    @GetMapping("/doctorappointment/{id}")
    public List<Appointment>doctorList(@PathVariable Long id)
    {
        return  service.getByDoctor(id);
    }
}
