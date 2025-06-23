package com.WebApp.BookMyDoctor.repository;

import com.WebApp.BookMyDoctor.Entity.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LeavesRepository extends JpaRepository<LeaveRequest, Long> {
    List<LeaveRequest> findByLeaveDoctorId(Long leaveDoctorId); // FIXED method name
}
