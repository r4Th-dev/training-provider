package de.r4thdev.trainingprovider.repositories;

import de.r4thdev.trainingprovider.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
}
