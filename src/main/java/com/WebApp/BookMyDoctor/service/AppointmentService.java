package com.WebApp.BookMyDoctor.service;

import com.WebApp.BookMyDoctor.Entity.Appointment;
import com.WebApp.BookMyDoctor.Entity.User;
import com.WebApp.BookMyDoctor.dto.AppointmentDto;
import com.WebApp.BookMyDoctor.exception.AppointmentException;
import com.WebApp.BookMyDoctor.repository.AppointmentRepository;
import com.WebApp.BookMyDoctor.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private AppointmentRepository repository1;

    public Appointment book(AppointmentDto dto) {

        if (repository1.findByDateTime(dto.getAppointmentTime()).isPresent())
            throw new AppointmentException("Appointment Date Already Booked Please Choose Different DateOrTime");

        else {
            Appointment appt = new Appointment();
            appt.setPatient(repository.findById(dto.getPatientId()).orElseThrow());
            appt.setDoctor(repository.findById(dto.getDoctorId()).orElseThrow());
            appt.setDateTime(dto.getAppointmentTime());
            Appointment saved = repository1.save(appt);
            System.out.println("Appointment booked with ID: " + saved.getId());
            return saved;
        }
    }
    public List<Appointment> getByDoctor(Long doctorId) {
        return repository1.findByDoctorId(doctorId);
    }

    public List<Appointment> getByPatient(Long patientId) {
        return repository1.findByPatientId(patientId);
    }
}
