package com.WebApp.BookMyDoctor.service;

import com.WebApp.BookMyDoctor.Entity.LeaveRequest;
import com.WebApp.BookMyDoctor.Entity.User;
import com.WebApp.BookMyDoctor.Entity.enums;
import com.WebApp.BookMyDoctor.dto.LeavesDto;
import com.WebApp.BookMyDoctor.exception.LeaveRequestException;
import com.WebApp.BookMyDoctor.repository.LeavesRepository;
import com.WebApp.BookMyDoctor.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class LeaveService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LeavesRepository leavesRepository;
    @Autowired
    private ModelMapper mapper;

    public LeaveRequest apply(@RequestBody LeavesDto dto) {
        if (dto == null || dto.getDoctorId() == null || dto.getToDate() == null || dto.getFromDate() == null) {
            throw new LeaveRequestException("Enter Valid Data");
        }
        User doctor = userRepository.findById(dto.getDoctorId())
                .orElseThrow(() -> new LeaveRequestException("Doctor ID not found"));

        LeaveRequest request = new LeaveRequest();
        request.setFromDate(dto.getFromDate());
        request.setToDate(dto.getToDate());
        request.setReason(dto.getReason());
        request.setStatus(enums.Status.PENDING);
        request.setLeaveDoctor(doctor);
        leavesRepository.save(request);
        return request;
    }

    @Cacheable(value = "leaveRequests", key = "#id")
    public List<LeaveRequest> allLeaves(Long id) {
        return leavesRepository.findByLeaveDoctorId(id);
    }

    public LeaveRequest approval(LeavesDto dto) {
       LeaveRequest doctor = leavesRepository.findById(dto.getDoctorId()).orElseThrow(() -> new LeaveRequestException("Invalid DoctorId"));


        doctor.setStatus(dto.getStatus());


        return leavesRepository.save(doctor);
    }
}
