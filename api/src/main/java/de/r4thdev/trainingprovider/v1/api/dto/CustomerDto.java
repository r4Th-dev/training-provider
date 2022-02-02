package de.r4thdev.trainingprovider.v1.api.dto;

import lombok.*;

import java.util.UUID;

@Data
@Builder
public class CustomerDto {
    private UUID id;
    private String name;
}
