package de.r4thdev.trainingprovider.v1.api.dto;

import lombok.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class AppointmentDto {
    private UUID id;
    private Instant date;
    private TrainingDto training;
    private TrainerDto trainer;
    private List<CustomerDto> registrations;
}
