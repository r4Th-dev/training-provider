package de.r4thdev.trainingprovider.v1.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationStatusDto {
    private AppointmentDto appointmentDto;
    private boolean registered;
    private String message;
}
