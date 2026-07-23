package com.chandan.doctor_service.dto;

import lombok.Data;

@Data
public class PatientResponseDto {
    private String name;
    private String email;
    private String phoneNumber;
    private Integer age;
    private String gender;
}
