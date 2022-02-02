package de.r4thdev.trainingprovider.v1.api;

import de.r4thdev.trainingprovider.v1.api.dto.AppointmentDto;
import de.r4thdev.trainingprovider.v1.api.dto.RegistrationStatusDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@RequestMapping(path = "/api/v1/appointments", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public interface AppointmentApi {

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    List<AppointmentDto> getAppointments();

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    AppointmentDto addAppointment(
            @RequestBody @Valid AppointmentDto appointmentApi);

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    AppointmentDto editAppointment(
            @RequestBody @Valid AppointmentDto appointmentApi);

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    RegistrationStatusDto register(UUID appointmentId, String customerName);

    @PostMapping("/unregister")
    @ResponseStatus(HttpStatus.OK)
    RegistrationStatusDto unregister(UUID appointmentId, String customerName);
}
