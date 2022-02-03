package de.r4thdev.trainingprovider.repositories;

import de.r4thdev.trainingprovider.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
}
