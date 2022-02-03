package de.r4thdev.trainingprovider.v1.api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.UUID;

@Data
@Builder
public class PersonDto {
    private UUID id;
    private String name;
    private HashMap<UUID, String> appointments;
}
