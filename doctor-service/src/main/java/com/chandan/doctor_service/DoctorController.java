package com.chandan.doctor_service;

import com.chandan.doctor_service.dto.DoctorRequestDto;
import com.chandan.doctor_service.dto.DoctorResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {
    private final DoctorService doctorService;
    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<DoctorResponseDto> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponseDto> getDoctorById(@PathVariable Long id) {
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }

    @PostMapping
    public ResponseEntity<DoctorResponseDto> createDoctor(@Valid @RequestBody DoctorRequestDto doctorRequestDto) {
        DoctorResponseDto savedDoctor = doctorService.createDoctor(doctorRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDoctor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorResponseDto> updateDoctor(@PathVariable Long id,@Valid @RequestBody DoctorRequestDto doctorRequestDto) {
        return ResponseEntity.ok(doctorService.updateDoctor(id, doctorRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}
