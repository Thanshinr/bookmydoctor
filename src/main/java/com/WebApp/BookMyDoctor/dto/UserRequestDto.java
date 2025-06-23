package com.WebApp.BookMyDoctor.dto;

import com.WebApp.BookMyDoctor.Entity.enums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    private String fullName;
    private String email;
    private String password;
    private String phone;
    private String location;
    private enums.Role role;
    private String specialization;
    private String gender;
    private Integer age;
    private Integer ratings;
}
