package com.WebApp.BookMyDoctor.dto;


import lombok.Data;
import com.WebApp.BookMyDoctor.Entity.enums;
import java.time.LocalDate;

@Data
public class LeavesDto {
    private Long doctorId;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String reason;
    private enums.Status status;

}
