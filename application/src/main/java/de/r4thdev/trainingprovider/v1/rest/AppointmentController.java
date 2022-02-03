package de.r4thdev.trainingprovider.v1.rest;

import de.r4thdev.trainingprovider.services.AppointmentService;
import de.r4thdev.trainingprovider.v1.api.AppointmentApi;
import de.r4thdev.trainingprovider.v1.api.dto.AppointmentDto;
import de.r4thdev.trainingprovider.v1.api.dto.RegistrationDto;
import de.r4thdev.trainingprovider.v1.api.dto.RegistrationStatusDto;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
public class AppointmentController implements AppointmentApi {

    @Autowired
    AppointmentService appointmentService;

    @Override
    public List<AppointmentDto> getAppointments() {
        return appointmentService.getAppointmentDtos();
    }

    @Override
    public AppointmentDto getAppointment(UUID id) {
        return appointmentService.getAppointmentDto(id);
    }

    @Override
    public AppointmentDto createAppointment(AppointmentDto appointmentDto) {
        return appointmentService.createAppointment(appointmentDto);
    }

    @Override
    public AppointmentDto editAppointment(AppointmentDto appointmentDto) {
        if (appointmentDto.getId() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "the id must not be null");
        return appointmentService.editAppointment(appointmentDto);
    }

    @Override
    public AppointmentDto deleteAppointment(UUID id) {
        return null;
    }

    @SneakyThrows
    @Override
    public RegistrationStatusDto register(RegistrationDto registrationDto) {
        return appointmentService.register(registrationDto);
    }

    @Override
    public RegistrationStatusDto unregister(RegistrationDto registrationDto) {
        return null;
    }
}
