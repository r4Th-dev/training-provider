package de.r4thdev.trainingprovider.repositories;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    @Column(name = "id", nullable = false)
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
