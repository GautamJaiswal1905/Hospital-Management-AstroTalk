package com.Hospital.service;

import com.Hospital.payload.PatientDto;

import java.util.List;

public interface PatientService {
    PatientDto addPatient(PatientDto patientDto);

    List<PatientDto> getAllPatient();

    PatientDto discharge(long id, String status);
}
