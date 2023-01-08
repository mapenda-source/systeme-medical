package com.mapenda.systememedical.controller;

import com.mapenda.systememedical.entity.User;
import com.mapenda.systememedical.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {



    @RequestMapping(value="/register", method = RequestMethod.GET)

    public ModelAndView showRegistrationPage(ModelAndView modelAndView, User user){
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register");
        return modelAndView;
    }

}
