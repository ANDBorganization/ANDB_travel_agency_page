package org.participation.base;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int customerId;

    @Column(nullable = false)
    private int packageId;

    @Column(nullable = false)
    private int employeeId;

    @Column(nullable = false)
    private LocalDate bookingDate;

    @Column(nullable = false)
    private int travelers;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalCost;
}
