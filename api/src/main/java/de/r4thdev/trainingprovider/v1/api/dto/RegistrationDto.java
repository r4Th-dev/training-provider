package de.r4thdev.trainingprovider.v1.api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class RegistrationDto {
    private UUID appointmentId;
    private UUID personId;
}
