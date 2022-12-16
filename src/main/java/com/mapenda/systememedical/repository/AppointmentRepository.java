package com.mapenda.systememedical.repository;

import com.mapenda.systememedical.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("appointmentRepository")
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {


}
