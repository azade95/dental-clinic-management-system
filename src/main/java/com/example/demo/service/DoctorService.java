package com.example.demo.service;

import com.example.demo.entity.Doctor;
import com.example.demo.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Doctor not found with id: " + id
                ));
    }

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Long id, Doctor doctor) {

        Doctor existingDoctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Doctor not found with id: " + id
                ));

        existingDoctor.setSpecialization(doctor.getSpecialization());
        existingDoctor.setLicenseNumber(doctor.getLicenseNumber());
        existingDoctor.setDescription(doctor.getDescription());
        existingDoctor.setActive(doctor.getActive());

        return doctorRepository.save(existingDoctor);
    }

    public void deleteDoctor(Long id) {

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Doctor not found with id: " + id
                ));

        doctorRepository.delete(doctor);
    }
}
