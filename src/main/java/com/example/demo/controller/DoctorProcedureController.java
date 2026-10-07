package com.example.demo.controller;

import com.example.demo.entity.DoctorProcedure;
import com.example.demo.service.DoctorProcedureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor-procedures")
public class DoctorProcedureController {

    private final DoctorProcedureService doctorProcedureService;

    public DoctorProcedureController(DoctorProcedureService doctorProcedureService) {
        this.doctorProcedureService = doctorProcedureService;
    }

    @GetMapping
    public List<DoctorProcedure> getAllDoctorProcedures() {
        return doctorProcedureService.getAllDoctorProcedures();
    }

    @GetMapping("/{id}")
    public DoctorProcedure getDoctorProcedureById(@PathVariable Long id) {
        return doctorProcedureService.getDoctorProcedureById(id);
    }

    @PostMapping
    public DoctorProcedure createDoctorProcedure(
            @RequestBody DoctorProcedure doctorProcedure) {
        return doctorProcedureService.createDoctorProcedure(doctorProcedure);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctorProcedure(@PathVariable Long id) {
        doctorProcedureService.deleteDoctorProcedure(id);
    }
}
