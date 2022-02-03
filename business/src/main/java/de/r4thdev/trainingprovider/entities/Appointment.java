package de.r4thdev.trainingprovider.entities;


import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "appointment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Appointment {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue
    private UUID id;

    @Column(name = "date", nullable = false, updatable = false)
    private Instant date;

    @ManyToOne(optional = false)
    @JoinColumn(name = "trainer_id")
    private Person trainer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "training_id")
    private Training training;

    @ManyToMany
    @JoinTable(
            name = "appointment_registrations",
            joinColumns = @JoinColumn(name = "registrations_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "appointment_id", referencedColumnName = "id"))
    private List<Person> registrations;
}
