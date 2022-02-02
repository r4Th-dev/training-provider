package de.r4thdev.trainingprovider.repositories;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationStatus {
    private String appointment;
    private String customer;
    private boolean registered;
}
