package com.chandan.doctor_service;

import com.chandan.doctor_service.dto.DoctorRequestDto;
import com.chandan.doctor_service.dto.DoctorResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    Doctor toEntity(DoctorRequestDto dto);

    DoctorResponseDto toResponseDto(Doctor doctor);
}
