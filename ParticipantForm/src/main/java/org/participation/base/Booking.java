package org.participation.base;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @ManyToOne
    private Participant participant;

    @ManyToOne
    private TravelPackage travelPackage;

    private int employeeId;
    private LocalDate bookingDate;
    private int travelers;
    private BigDecimal totalCost;
}
