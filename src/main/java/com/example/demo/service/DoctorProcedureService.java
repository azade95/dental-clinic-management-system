package com.example.demo.service;

import com.example.demo.entity.DoctorProcedure;
import com.example.demo.repository.DoctorProcedureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorProcedureService {

    private final DoctorProcedureRepository doctorProcedureRepository;

    public DoctorProcedureService(DoctorProcedureRepository doctorProcedureRepository) {
        this.doctorProcedureRepository = doctorProcedureRepository;
    }

    public List<DoctorProcedure> getAllDoctorProcedures() {
        return doctorProcedureRepository.findAll();
    }

    public DoctorProcedure getDoctorProcedureById(Long id) {
        return doctorProcedureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "DoctorProcedure not found with id: " + id
                ));
    }

    public DoctorProcedure createDoctorProcedure(DoctorProcedure doctorProcedure) {
        return doctorProcedureRepository.save(doctorProcedure);
    }

    public void deleteDoctorProcedure(Long id) {
        DoctorProcedure doctorProcedure = doctorProcedureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "DoctorProcedure not found with id: " + id
                ));

        doctorProcedureRepository.delete(doctorProcedure);
    }
}