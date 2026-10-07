package com.example.demo.controller;

import com.example.demo.entity.Procedure;
import com.example.demo.service.ProcedureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/procedures")
public class ProcedureController {

    private final ProcedureService procedureService;

    public ProcedureController(ProcedureService procedureService) {
        this.procedureService = procedureService;
    }

    @GetMapping
    public List<Procedure> getAllProcedures() {
        return procedureService.getAllProcedures();
    }

    @GetMapping("/{id}")
    public Procedure getProcedureById(@PathVariable Long id) {
        return procedureService.getProcedureById(id);
    }

    @PostMapping
    public Procedure createProcedure(@RequestBody Procedure procedure) {
        return procedureService.createProcedure(procedure);
    }

    @PutMapping("/{id}")
    public Procedure updateProcedure(
            @PathVariable Long id,
            @RequestBody Procedure procedure) {
        return procedureService.updateProcedure(id, procedure);
    }

    @DeleteMapping("/{id}")
    public void deleteProcedure(@PathVariable Long id) {
        procedureService.deleteProcedure(id);
    }
}
