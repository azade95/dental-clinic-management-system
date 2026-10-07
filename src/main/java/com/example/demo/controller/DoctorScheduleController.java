package com.example.demo.controller;

import com.example.demo.entity.DoctorSchedule;
import com.example.demo.service.DoctorScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor-schedules")
public class DoctorScheduleController {

    private final DoctorScheduleService doctorScheduleService;

    public DoctorScheduleController(DoctorScheduleService doctorScheduleService) {
        this.doctorScheduleService = doctorScheduleService;
    }

    @GetMapping
    public List<DoctorSchedule> getAllSchedules() {
        return doctorScheduleService.getAllSchedules();
    }

    @GetMapping("/{id}")
    public DoctorSchedule getScheduleById(@PathVariable Long id) {
        return doctorScheduleService.getScheduleById(id);
    }

    @PostMapping
    public DoctorSchedule createSchedule(
            @RequestBody DoctorSchedule schedule) {
        return doctorScheduleService.createSchedule(schedule);
    }

    @PutMapping("/{id}")
    public DoctorSchedule updateSchedule(
            @PathVariable Long id,
            @RequestBody DoctorSchedule schedule) {
        return doctorScheduleService.updateSchedule(id, schedule);
    }

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id) {
        doctorScheduleService.deleteSchedule(id);
    }
}
