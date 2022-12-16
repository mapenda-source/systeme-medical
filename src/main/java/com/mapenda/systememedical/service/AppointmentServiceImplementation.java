package com.mapenda.systememedical.service;

import com.mapenda.systememedical.entity.Appointment;
import com.mapenda.systememedical.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImplementation  {

    private AppointmentRepository appointmentRepository;

    //inject employee dao
    @Autowired   //Adding bean id @Qualifier
    public AppointmentServiceImplementation( AppointmentRepository obj)
    {
        appointmentRepository=obj;
    }


    public void save(Appointment app)
    {

        appointmentRepository.save(app);
    }


    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }



}