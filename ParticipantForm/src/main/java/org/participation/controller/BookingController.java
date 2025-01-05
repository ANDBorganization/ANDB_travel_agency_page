package org.participation.controller;

import org.participation.base.Booking;
import org.participation.base.Participant;
import org.participation.dto.BookingRequest;
import org.participation.repository.BookingRepository;
import org.participation.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping
    public ResponseEntity<?> createBookings(@RequestBody List<BookingRequest> bookingRequest) {
        try {
            List<Booking> entities = bookingRequest.stream().map(dto -> {
                        Booking booking = new Booking();
                        booking.setCustomerId(dto.getParticipantId());
                        booking.setPackageId(dto.getPackageId());
                        booking.setEmployeeId(dto.getEmployeeId());
                        booking.setBookingDate(LocalDate.now());
                        booking.setTravelers(dto.getTravelers());
                        booking.setTotalCost(BigDecimal.ZERO);
                        return booking;
                    }).toList();

            bookingRepository.saveAll(entities);
            return ResponseEntity.status(HttpStatus.CREATED).body("Bookings created successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }
}