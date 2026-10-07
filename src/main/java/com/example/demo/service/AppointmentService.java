package com.example.demo.service;

import com.example.demo.entity.Appointment;
import com.example.demo.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Appointment not found with id: " + id
                ));
    }

    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(Long id, Appointment appointment) {
        Appointment existingAppointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Appointment not found with id: " + id
                ));

        existingAppointment.setPatient(appointment.getPatient());
        existingAppointment.setDoctor(appointment.getDoctor());
        existingAppointment.setProcedure(appointment.getProcedure());
        existingAppointment.setRoom(appointment.getRoom());
        existingAppointment.setAppointmentDate(appointment.getAppointmentDate());
        existingAppointment.setStartTime(appointment.getStartTime());
        existingAppointment.setEndTime(appointment.getEndTime());
        existingAppointment.setStatus(appointment.getStatus());
        existingAppointment.setPrice(appointment.getPrice());
        existingAppointment.setNotes(appointment.getNotes());

        return appointmentRepository.save(existingAppointment);
    }

    public void deleteAppointment(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Appointment not found with id: " + id
                ));

        appointmentRepository.delete(appointment);
    }
}
