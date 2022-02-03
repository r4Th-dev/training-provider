package de.r4thdev.trainingprovider.v1.api.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.HashMap;
import java.util.UUID;

@Data
@Builder
public class AppointmentDto {
    private UUID id;
    private Instant date;
    private TrainingDto training;
    private PersonDto trainer;
    private HashMap<UUID, String> registrations;
}
