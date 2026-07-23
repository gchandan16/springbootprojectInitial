package com.chandan.doctor_service;
import com.chandan.doctor_service.dto.PatientRequestDto;
import com.chandan.doctor_service.dto.PatientResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientServiceImpl(PatientRepository patientRepository,PatientMapper patientMapper){
        this.patientRepository = patientRepository;
        this.patientMapper=patientMapper;
    }

    @Override
    public List<PatientResponseDto> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(patientMapper::toResponseDto)
                .toList();
    }

    @Override
    public PatientResponseDto getPatientById(Long id) {
        Patient patient= patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
        return patientMapper.toResponseDto(patient);
    }

    @Override
    public PatientResponseDto  createPatient(PatientRequestDto patientRequestDto) {
        Patient patient= patientMapper.toEntity(patientRequestDto);
        Patient savePatient=patientRepository.save(patient);
        return patientMapper.toResponseDto(savePatient);
    }


    @Override
    public PatientResponseDto updatePatient(Long id, PatientRequestDto patientRequestDto) {
        Patient existingPatient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));

        existingPatient.setName(patientRequestDto.getName());
        existingPatient.setEmail(patientRequestDto.getEmail());
        existingPatient.setPhoneNumber(patientRequestDto.getPhoneNumber());
        existingPatient.setAge(patientRequestDto.getAge());
        existingPatient.setGender(patientRequestDto.getGender());
        Patient updatePatient=patientRepository.save(existingPatient);
        return patientMapper.toResponseDto(updatePatient);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

}
