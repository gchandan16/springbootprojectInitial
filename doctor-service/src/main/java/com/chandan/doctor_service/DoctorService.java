package com.chandan.doctor_service;

import com.chandan.doctor_service.dto.DoctorRequestDto;
import com.chandan.doctor_service.dto.DoctorResponseDto;

import java.util.List;

public interface DoctorService {

    List<DoctorResponseDto> getAllDoctors();

    DoctorResponseDto getDoctorById(Long id);

    DoctorResponseDto  createDoctor(DoctorRequestDto doctorRequestDto);

    DoctorResponseDto  updateDoctor(Long id, DoctorRequestDto doctorRequestDto);

    void deleteDoctor(Long id);

}
