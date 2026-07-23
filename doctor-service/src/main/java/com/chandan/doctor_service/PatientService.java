package com.chandan.doctor_service;

import com.chandan.doctor_service.dto.PatientRequestDto;
import com.chandan.doctor_service.dto.PatientResponseDto;

import java.util.List;

public interface PatientService {

    List<PatientResponseDto> getAllPatients();

    PatientResponseDto getPatientById(Long id);

    PatientResponseDto  createPatient(PatientRequestDto patientRequestDto);

    PatientResponseDto  updatePatient(Long id, PatientRequestDto patientRequestDto);

    void deletePatient(Long id);
}
