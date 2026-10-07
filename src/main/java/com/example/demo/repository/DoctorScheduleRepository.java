package com.example.demo.repository;

import com.example.demo.entity.DoctorSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorScheduleRepository extends JpaRepository<DoctorSchedule, Long> {
}
