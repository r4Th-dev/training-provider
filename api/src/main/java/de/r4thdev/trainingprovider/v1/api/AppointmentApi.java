package de.r4thdev.trainingprovider.v1.api;

import de.r4thdev.trainingprovider.v1.api.dto.AppointmentDto;
import de.r4thdev.trainingprovider.v1.api.dto.RegistrationDto;
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

    @GetMapping("/{personId}")
    @ResponseStatus(HttpStatus.OK)
    List<AppointmentDto> getAppointments(
            @RequestParam UUID personId
    );

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
    RegistrationStatusDto register(
            @RequestBody RegistrationDto registrationDto);

    @PostMapping("/unregister")
    @ResponseStatus(HttpStatus.OK)
    RegistrationStatusDto unregister(
            @RequestBody RegistrationDto registrationDto);
}
