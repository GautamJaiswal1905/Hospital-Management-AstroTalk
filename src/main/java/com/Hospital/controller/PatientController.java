package com.Hospital.controller;


import com.Hospital.entity.Patient;
import com.Hospital.payload.DischargeDto;
import com.Hospital.payload.PatientDto;
import com.Hospital.repository.PatientRepository;
import com.Hospital.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/addpatient")
    public ResponseEntity<PatientDto> addPatients(@RequestBody PatientDto patientDto) {
        PatientDto dto = patientService.addPatient(patientDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/getpatient")
    public List<PatientDto> getPatients() {
        List<PatientDto> dto = patientService.getAllPatient();
        return dto;
    }

    @PutMapping("{id}")
    public ResponseEntity<String> dischargePatient(@PathVariable("id") long id){
        DischargeDto dischargeDto = new DischargeDto();

        PatientDto dto = patientService.discharge(id, dischargeDto.getStatus());
        return new ResponseEntity<>("Patient "+dto.getName()+"has been 'Discharged'", HttpStatus.OK);


    }

}
