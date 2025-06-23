package com.WebApp.BookMyDoctor.repository;

import com.WebApp.BookMyDoctor.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDoctorId(Long doctorId);  // OK
    List<Appointment> findByPatientId(Long patientId);
    Optional<Appointment> findByDateTime(LocalDateTime data);// FIXED method name
}
