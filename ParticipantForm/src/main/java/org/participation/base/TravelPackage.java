package org.participation.base;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class TravelPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int packageId;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "destinationID", referencedColumnName = "destinationId", nullable = false)
    private Destination destination;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private BigDecimal price;
}
