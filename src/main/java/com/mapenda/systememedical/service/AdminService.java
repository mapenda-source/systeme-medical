package com.mapenda.systememedical.service;

import com.mapenda.systememedical.entity.Admin;

import java.util.List;

public interface AdminService {


    public List<Admin> findByRole(String user);

    public Admin findByEmail(String user);

    public List<Admin> findAll();

    public void save(Admin admin);

}