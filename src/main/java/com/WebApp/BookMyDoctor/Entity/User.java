package com.WebApp.BookMyDoctor.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usersObj")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String email;
    private String password;
    private String phone;
    private String location;
    private int age;

    @Enumerated(EnumType.STRING)
    private enums.Role role;

    //Doctor
    private String specialization;
    private Integer ratings;

    // Patient
    private String gender;
//    private String dob;


    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Appointment> patientAppointment;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    @JsonIgnore

    private List<Appointment> doctorAppointment;

    @OneToMany(mappedBy = "leaveDoctor", cascade = CascadeType.ALL)
    @JsonIgnore

    private List<LeaveRequest> leaveRequests;

}
