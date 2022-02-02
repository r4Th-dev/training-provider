package de.r4thdev.trainingprovider.services;

import de.r4thdev.trainingprovider.mapper.AppointmentMapper;
import de.r4thdev.trainingprovider.repositories.Appointment;
import de.r4thdev.trainingprovider.repositories.AppointmentRepository;
import de.r4thdev.trainingprovider.v1.api.dto.AppointmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    AppointmentMapper appointmentMapper = AppointmentMapper.INSTANCE;

    public List<Appointment> getAppointments() {
        return appointmentRepository.findAll();
    }

    public AppointmentDto createAppointment(AppointmentDto appointmentDto) {
        return appointmentMapper.appointmentToAppointmentDto(
                appointmentRepository.save(
                        appointmentMapper.appointmentDtoToAppointment(appointmentDto)
                ));
    }
}

