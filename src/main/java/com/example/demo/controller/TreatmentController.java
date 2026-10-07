package com.example.demo.controller;

import com.example.demo.entity.Treatment;
import com.example.demo.service.TreatmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/treatments")
public class TreatmentController {

    private final TreatmentService treatmentService;

    public TreatmentController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @GetMapping
    public List<Treatment> getAllTreatments() {
        return treatmentService.getAllTreatments();
    }

    @GetMapping("/{id}")
    public Treatment getTreatmentById(@PathVariable Long id) {
        return treatmentService.getTreatmentById(id);
    }

    @PostMapping
    public Treatment createTreatment(@RequestBody Treatment treatment) {
        return treatmentService.createTreatment(treatment);
    }

    @PutMapping("/{id}")
    public Treatment updateTreatment(
            @PathVariable Long id,
            @RequestBody Treatment treatment) {
        return treatmentService.updateTreatment(id, treatment);
    }

    @DeleteMapping("/{id}")
    public void deleteTreatment(@PathVariable Long id) {
        treatmentService.deleteTreatment(id);
    }
}
