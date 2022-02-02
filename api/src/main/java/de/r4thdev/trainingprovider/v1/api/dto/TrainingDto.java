package de.r4thdev.trainingprovider.v1.api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class TrainingDto {

    private UUID id;
    private String name;
    private String description;
    private Long price;
    private String currency;
}
