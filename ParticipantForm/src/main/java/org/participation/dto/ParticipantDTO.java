package org.participation.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ParticipantDTO {
    @NotEmpty(message = "Name is required and cannot be empty.")
    @Size(max = 100, message = "Name must not exceed 100 characters.")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must contain only letters and spaces.")
    private String name;

    @NotEmpty(message = "Surname is required and cannot be empty.")
    @Size(max = 100, message = "Surname must not exceed 100 characters.")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Surname must contain only letters and spaces.")
    private String surname;

    @NotNull(message = "Date of Birth is required.")
    @Past(message = "Date of Birth must be in the past.")
    private LocalDate dateOfBirth;

    @NotEmpty(message = "Address is required and cannot be empty.")
    @Size(max = 255, message = "Email must not exceed 255 characters.")
    private String address;

    @NotEmpty(message = "Email is required and cannot be empty.")
    @Size(max = 100, message = "Email must not exceed 100 characters.")
    @Email(message = "Email must be valid.")
    private String email;

    @NotEmpty(message = "Phone number is required and cannot be empty.")
    @Size(max = 15, message = "Phone number must not exceed 15 characters.")
    @Pattern(regexp = "^[0-9+\\-\\s]+$", message = "Phone number must contain only digits, spaces, dashes, or plus signs.")
    private String phone;
}
