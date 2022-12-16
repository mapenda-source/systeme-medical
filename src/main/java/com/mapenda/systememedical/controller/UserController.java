package com.mapenda.systememedical.controller;

import com.mapenda.systememedical.entity.Admin;
import com.mapenda.systememedical.entity.Appointment;
import com.mapenda.systememedical.service.AdminServiceImplementation;
import com.mapenda.systememedical.service.AppointmentServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
    @RequestMapping("/user")
    public class UserController {

        private AppointmentServiceImplementation appointmentServiceImplementation;

        private AdminServiceImplementation adminServiceImplementation;

        @Autowired
        public UserController(AppointmentServiceImplementation obj1, AdminServiceImplementation obj) {
            appointmentServiceImplementation = obj1;
            adminServiceImplementation = obj;

        }

        @GetMapping("/index")
        public String index(Model model) {

            // get last seen
            String username = "";
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                username = ((UserDetails) principal).getUsername();
                String Pass = ((UserDetails) principal).getPassword();
                System.out.println("One + " + username + "   " + Pass);


            } else {
                username = principal.toString();
                System.out.println("Two + " + username);
            }

            Admin admin = adminServiceImplementation.findByEmail(username);

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date now = new Date();

            String log = now.toString();

            admin.setLastseen(log);

            adminServiceImplementation.save(admin);


            Appointment obj = new Appointment();

            obj.setName(admin.getFirstName() + " " + admin.getLastName());

            obj.setEmail(admin.getEmail());

            System.out.println(obj);

            model.addAttribute("app", obj);

            return "user/index";
        }
    }
