package com.chandan.doctor_service.dto;


import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class DoctorRequestDto {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Specialization is required")
    private String specialization;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    @NotNull(message = "Years of experience is required")
    @Min(value = 0, message = "Years of experience cannot be negative")
    private Integer yearsOfExperience;

    @NotNull(message = "Consultation fee is required")
    @Positive(message = "Consultation fee must be positive")
    private Double consultationFee;

    @NotNull(message = "Availability status is required")
    private Boolean available;
}
