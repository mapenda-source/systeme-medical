package com.mapenda.systememedical.repository;

import com.mapenda.systememedical.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("adminRepository")
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByEmail(String user);

    List<Admin> findByRole(String user);
}
