package com.chandan.doctor_service;

import com.chandan.doctor_service.dto.PatientRequestDto;
import com.chandan.doctor_service.dto.PatientResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface PatientMapper {
    Patient toEntity(PatientRequestDto dto);
    PatientResponseDto toResponseDto(Patient patient);
}
