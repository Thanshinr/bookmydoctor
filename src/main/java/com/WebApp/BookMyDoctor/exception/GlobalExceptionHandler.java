package com.WebApp.BookMyDoctor.exception;

import com.WebApp.BookMyDoctor.config.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserExistException.class)
    public ResponseEntity<ApiResponse> userAlreadyExist(UserExistException u) {
        ApiResponse a = new ApiResponse();
        a.setError(u.getMessage());
        a.setData(null);
        a.setStatus(HttpStatus.CONFLICT);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(a);
    }


    @ExceptionHandler(LoginException.class)
    public ResponseEntity<ApiResponse> userLogin(LoginException u) {
        ApiResponse a = new ApiResponse();
        a.setStatus(HttpStatus.UNAUTHORIZED);
        a.setError(u.getMessage());
        a.setData(null);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(a);
    }

    @ExceptionHandler(LeaveRequestException.class)
    public ResponseEntity<ApiResponse> leaveRequest(LeaveRequestException e) {
        ApiResponse a = new ApiResponse<>();
        a.setData(null);
        a.setError(e.getMessage());
        a.setStatus(HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(a);
    }

    @ExceptionHandler(AppointmentException.class)
    public ResponseEntity<ApiResponse> appointBook(AppointmentException e) {
        ApiResponse a = new ApiResponse();
        a.setStatus(HttpStatus.ALREADY_REPORTED);
        a.setError(e.getMessage());
        a.setData(null);
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(a);
    }
}
