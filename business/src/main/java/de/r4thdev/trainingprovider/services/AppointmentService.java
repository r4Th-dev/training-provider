package de.r4thdev.trainingprovider.services;

import de.r4thdev.trainingprovider.repositories.Appointment;
import de.r4thdev.trainingprovider.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;

    public List<Appointment> getAppointments() {
        return appointmentRepository.findAll();
    }
}

