package de.r4thdev.trainingprovider.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrainerRepository extends JpaRepository<Trainer, UUID> {
}
