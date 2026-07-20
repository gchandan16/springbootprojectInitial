package com.chandan.doctor_service;

import org.springframework.stereotype.Service;

import java.util.List;
import com.chandan.doctor_service.dto.DoctorRequestDto;
import com.chandan.doctor_service.dto.DoctorResponseDto;
@Service
public class DoctorServiceImpl  implements DoctorService  {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;


    public DoctorServiceImpl(DoctorRepository doctorRepository,DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper=doctorMapper;
    }

    @Override
    public List<DoctorResponseDto> getAllDoctors() {
        return doctorRepository.findAll()
                .stream()
                .map(doctorMapper::toResponseDto)
                .toList();
    }

    @Override
    public DoctorResponseDto getDoctorById(Long id) {
        Doctor doctor= doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));
        return doctorMapper.toResponseDto(doctor);
    }

    @Override
    public DoctorResponseDto  createDoctor(DoctorRequestDto doctorRequestDto) {
        Doctor doctor= doctorMapper.toEntity(doctorRequestDto);
        Doctor saveDoctor=doctorRepository.save(doctor);
        return doctorMapper.toResponseDto(saveDoctor);
    }

    @Override
    public DoctorResponseDto updateDoctor(Long id, DoctorRequestDto doctorRequestDto) {
        Doctor existingDoctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));

        existingDoctor.setName(doctorRequestDto.getName());
        existingDoctor.setSpecialization(doctorRequestDto.getSpecialization());
        existingDoctor.setEmail(doctorRequestDto.getEmail());
        existingDoctor.setPhoneNumber(doctorRequestDto.getPhoneNumber());
        existingDoctor.setYearsOfExperience(doctorRequestDto.getYearsOfExperience());
        existingDoctor.setConsultationFee(doctorRequestDto.getConsultationFee());
        existingDoctor.setAvailable(doctorRequestDto.getAvailable());
        Doctor updateDoctor=doctorRepository.save(existingDoctor);
        return doctorMapper.toResponseDto(updateDoctor);
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
