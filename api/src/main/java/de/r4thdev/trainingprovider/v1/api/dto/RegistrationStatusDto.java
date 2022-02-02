package de.r4thdev.trainingprovider.v1.api.dto;

import lombok.*;

@Data
@Builder
public class RegistrationStatusDto {
    private String appointment;
    private String customer;
    private boolean registered;
}
