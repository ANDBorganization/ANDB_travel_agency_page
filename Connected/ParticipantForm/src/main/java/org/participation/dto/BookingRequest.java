package org.participation.dto;

import lombok.Data;
import org.participation.base.Participant;

import java.util.List;

@Data
public class BookingRequest {
    private int participantId;
    private int packageId;
    private Integer employeeId;
    private Integer travelers;
}