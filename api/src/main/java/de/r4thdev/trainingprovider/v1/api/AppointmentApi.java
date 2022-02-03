package de.r4thdev.trainingprovider.v1.api;

import de.r4thdev.trainingprovider.v1.api.dto.AppointmentDto;
import de.r4thdev.trainingprovider.v1.api.dto.RegistrationDto;
import de.r4thdev.trainingprovider.v1.api.dto.RegistrationStatusDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RequestMapping(path = "/api/v1/appointments", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public interface AppointmentApi {

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    List<AppointmentDto> getAppointments();

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    AppointmentDto getAppointment(
            @PathVariable UUID id
    );

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    AppointmentDto createAppointment(
            @RequestBody AppointmentDto appointmentDto
    );

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    AppointmentDto editAppointment(
            @RequestBody AppointmentDto appointmentDto
    );

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    AppointmentDto deleteAppointment(
            @PathVariable UUID id
    );

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    RegistrationStatusDto register(
            @RequestBody RegistrationDto registrationDto
    );

    @PostMapping("/unregister")
    @ResponseStatus(HttpStatus.OK)
    RegistrationStatusDto unregister(
            @RequestBody RegistrationDto registrationDto
    );
}
