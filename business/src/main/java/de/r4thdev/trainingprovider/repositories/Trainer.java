package de.r4thdev.trainingprovider.repositories;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;
}
