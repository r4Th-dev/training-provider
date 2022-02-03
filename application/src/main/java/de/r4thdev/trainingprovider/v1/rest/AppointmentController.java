package de.r4thdev.trainingprovider.v1.rest;

import de.r4thdev.trainingprovider.mapper.AppointmentMapper;
import de.r4thdev.trainingprovider.services.AppointmentService;
import de.r4thdev.trainingprovider.v1.api.AppointmentApi;
import de.r4thdev.trainingprovider.v1.api.dto.AppointmentDto;
import de.r4thdev.trainingprovider.v1.api.dto.RegistrationDto;
import de.r4thdev.trainingprovider.v1.api.dto.RegistrationStatusDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AppointmentController implements AppointmentApi {

    @Autowired
    AppointmentService appointmentService;

    AppointmentMapper appointmentMapper = AppointmentMapper.INSTANCE;

    @Override
    public List<AppointmentDto> getAppointments() {
        return appointmentService.getAppointments()
                .stream()
                .map(appointmentMapper::appointmentToAppointmentDto)
                .collect(Collectors.toList());
    }

    @Override
    public AppointmentDto addAppointment(AppointmentDto appointmentDto) {
        return appointmentService.createAppointment(appointmentDto);
    }

    @Override
    public AppointmentDto editAppointment(AppointmentDto appointmentApi) {
        return null;
    }

    @Override
    public RegistrationStatusDto register(RegistrationDto registrationDto) {
        return appointmentService.register(registrationDto.getAppointmentId(), registrationDto.getPersonId());
    }

    @Override
    public RegistrationStatusDto unregister(RegistrationDto registrationDto) {
        return null;
    }
}
