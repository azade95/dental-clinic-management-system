package com.example.demo.repository;

import com.example.demo.entity.DoctorProcedure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorProcedureRepository extends JpaRepository<DoctorProcedure, Long> {
}
