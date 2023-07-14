package com.Hospital.service.impl;

import com.Hospital.entity.Patient;
import com.Hospital.exception.ResourceNotFoundException;
import com.Hospital.payload.PatientDto;
import com.Hospital.repository.PatientRepository;
import com.Hospital.repository.StaffRepository;
import com.Hospital.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PatientServiceImpl implements PatientService {
    private StaffRepository staffRepository;
    private ModelMapper modelMapper;

    private PatientRepository patientRepository;

    public PatientServiceImpl(StaffRepository staffRepository, ModelMapper modelMapper, PatientRepository patientRepository) {
        this.staffRepository = staffRepository;
        this.modelMapper = modelMapper;
        this.patientRepository=patientRepository;
    }

    @Override
    public PatientDto addPatient(PatientDto patientDto) {

        Patient patient = mapToEntity(patientDto);
        Patient savePatient = patientRepository.save(patient);
        PatientDto dto = mapToDto(savePatient);
        return dto;
    }

    @Override
    public List<PatientDto> getAllPatient() {
        List<Patient> patient = patientRepository.findAll();
        List<PatientDto> dtoList = patient.stream().map(patients -> mapToDto(patients)).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public PatientDto discharge(long id, String status) {
        Patient patient = patientRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException(id)
        );
        patient.setId(id);
        patient.setStatus(status);
        Patient disChargedPatient = patientRepository.save(patient);
        PatientDto dto = mapToDto(disChargedPatient);
        return dto;
    }


    Patient mapToEntity(PatientDto patientDto){
        Patient patient = modelMapper.map(patientDto, Patient.class);
        return patient;
    }

    PatientDto mapToDto(Patient patient){
        PatientDto patientDto = modelMapper.map(patient, PatientDto.class);
        return patientDto;
    }

}
