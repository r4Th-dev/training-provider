package de.r4thdev.trainingprovider.repositories;


import lombok.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "trainer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Trainer {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;
}
