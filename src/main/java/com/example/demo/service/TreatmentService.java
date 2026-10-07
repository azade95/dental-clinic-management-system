package com.example.demo.service;

import com.example.demo.entity.Treatment;
import com.example.demo.repository.TreatmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentService {

    private final TreatmentRepository treatmentRepository;

    public TreatmentService(TreatmentRepository treatmentRepository) {
        this.treatmentRepository = treatmentRepository;
    }

    public List<Treatment> getAllTreatments() {
        return treatmentRepository.findAll();
    }

    public Treatment getTreatmentById(Long id) {
        return treatmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Treatment not found with id: " + id
                ));
    }

    public Treatment createTreatment(Treatment treatment) {
        return treatmentRepository.save(treatment);
    }

    public Treatment updateTreatment(Long id, Treatment treatment) {
        Treatment existingTreatment = treatmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Treatment not found with id: " + id
                ));

        existingTreatment.setPatient(treatment.getPatient());
        existingTreatment.setDoctor(treatment.getDoctor());
        existingTreatment.setProcedure(treatment.getProcedure());
        existingTreatment.setAppointment(treatment.getAppointment());
        existingTreatment.setToothNumber(treatment.getToothNumber());
        existingTreatment.setStatus(treatment.getStatus());
        existingTreatment.setNotes(treatment.getNotes());

        return treatmentRepository.save(existingTreatment);
    }

    public void deleteTreatment(Long id) {
        Treatment treatment = treatmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Treatment not found with id: " + id
                ));

        treatmentRepository.delete(treatment);
    }
}