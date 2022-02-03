package de.r4thdev.trainingprovider.entities;


import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "training")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Training {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Long price;

    @Column(name = "currency")
    private String currency;
}
