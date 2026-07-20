package com.chandan.doctor_service.dto;
import lombok.Data;
@Data
public class DoctorResponseDto {
    private Long id;
    private String name;
    private String specialization;
    private String email;
    private String phoneNumber;
    private Integer yearsOfExperience;
    private Double consultationFee;
    private Boolean available;
}
