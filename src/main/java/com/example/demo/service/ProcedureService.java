package com.example.demo.service;

import com.example.demo.entity.Procedure;
import com.example.demo.repository.ProcedureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcedureService {

    private final ProcedureRepository procedureRepository;

    public ProcedureService(ProcedureRepository procedureRepository) {
        this.procedureRepository = procedureRepository;
    }

    public List<Procedure> getAllProcedures() {
        return procedureRepository.findAll();
    }

    public Procedure getProcedureById(Long id) {
        return procedureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Procedure not found with id: " + id
                ));
    }

    public Procedure createProcedure(Procedure procedure) {
        return procedureRepository.save(procedure);
    }

    public Procedure updateProcedure(Long id, Procedure procedure) {
        Procedure existingProcedure = procedureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Procedure not found with id: " + id
                ));

        existingProcedure.setName(procedure.getName());
        existingProcedure.setDescription(procedure.getDescription());
        existingProcedure.setDuration(procedure.getDuration());
        existingProcedure.setPrice(procedure.getPrice());
        existingProcedure.setActive(procedure.getActive());

        return procedureRepository.save(existingProcedure);
    }

    public void deleteProcedure(Long id) {
        Procedure procedure = procedureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Procedure not found with id: " + id
                ));

        procedureRepository.delete(procedure);
    }
}
