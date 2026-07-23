package com.chandan.doctor_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PatientRequestDto {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;
    @NotBlank(message = "Phone number is required")
    private String phoneNumber;
    @NotBlank(message = "Age is required")
    private Integer age;
    @NotBlank(message = "Gender is required")
    private String gender;

}
