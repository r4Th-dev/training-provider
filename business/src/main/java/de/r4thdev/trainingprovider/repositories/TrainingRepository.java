package de.r4thdev.trainingprovider.repositories;

import de.r4thdev.trainingprovider.entities.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrainingRepository extends JpaRepository<Training, UUID> {
}
