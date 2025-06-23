package com.WebApp.BookMyDoctor.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class AppointmentDto {

    private Long patientId;
    private Long doctorId;
    private LocalDateTime appointmentTime;
}
