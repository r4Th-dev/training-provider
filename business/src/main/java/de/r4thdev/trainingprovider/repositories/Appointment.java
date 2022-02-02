package de.r4thdev.trainingprovider.repositories;


import lombok.*;

import javax.persistence.*;
import java.time.Instant;
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
    private UUID id;

    @Column(name = "date", nullable = false, updatable = false)
    private Instant date;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "training_id")
    private Training training;

}
