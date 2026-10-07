package com.example.demo.service;

import com.example.demo.entity.DoctorSchedule;
import com.example.demo.repository.DoctorScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorScheduleService {

    private final DoctorScheduleRepository doctorScheduleRepository;

    public DoctorScheduleService(DoctorScheduleRepository doctorScheduleRepository) {
        this.doctorScheduleRepository = doctorScheduleRepository;
    }

    public List<DoctorSchedule> getAllSchedules() {
        return doctorScheduleRepository.findAll();
    }

    public DoctorSchedule getScheduleById(Long id) {
        return doctorScheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "DoctorSchedule not found with id: " + id
                ));
    }

    public DoctorSchedule createSchedule(DoctorSchedule schedule) {
        return doctorScheduleRepository.save(schedule);
    }

    public DoctorSchedule updateSchedule(Long id, DoctorSchedule schedule) {
        DoctorSchedule existingSchedule = doctorScheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "DoctorSchedule not found with id: " + id
                ));

        existingSchedule.setDoctor(schedule.getDoctor());
        existingSchedule.setDayOfWeek(schedule.getDayOfWeek());
        existingSchedule.setStartTime(schedule.getStartTime());
        existingSchedule.setEndTime(schedule.getEndTime());
        existingSchedule.setBreakStart(schedule.getBreakStart());
        existingSchedule.setBreakEnd(schedule.getBreakEnd());
        existingSchedule.setActive(schedule.getActive());

        return doctorScheduleRepository.save(existingSchedule);
    }

    public void deleteSchedule(Long id) {
        DoctorSchedule schedule = doctorScheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "DoctorSchedule not found with id: " + id
                ));

        doctorScheduleRepository.delete(schedule);
    }
}
