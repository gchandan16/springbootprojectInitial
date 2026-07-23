package com.chandan.doctor_service;
import com.chandan.doctor_service.dto.PatientRequestDto;
import com.chandan.doctor_service.dto.PatientResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService=patientService;
    }

    @GetMapping
    public List<PatientResponseDto> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponseDto> getPatientById(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    @PostMapping
    public ResponseEntity<PatientResponseDto> createDoctor(@Valid @RequestBody PatientRequestDto patientRequestDto) {
        PatientResponseDto savedPatient = patientService.createPatient(patientRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPatient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponseDto> updatePatient(@PathVariable Long id,@Valid @RequestBody PatientRequestDto patientRequestDto) {
        return ResponseEntity.ok(patientService.updatePatient(id, patientRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

}
