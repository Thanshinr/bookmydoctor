package com.WebApp.BookMyDoctor.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data

public class LeaveRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private enums.Status status;

    @Column(length = 500)
    private String reason;

    @Column(name = "start_date")
    private LocalDate fromDate;

    @Column(name = "end_date")
    private LocalDate toDate;

    @ManyToOne
    @JoinColumn(name = "leave_id")
    @JsonIgnore

    private User leaveDoctor;
}
