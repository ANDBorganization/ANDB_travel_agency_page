package org.participation.base;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.Data;

@Entity
@Data
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int destinationId;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String country;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private double price;
}
