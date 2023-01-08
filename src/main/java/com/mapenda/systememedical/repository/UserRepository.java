package com.mapenda.systememedical.repository;

import com.mapenda.systememedical.entity.User;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

    User findByConfirmationToken(String confirmationToken);

    List<User> findAll();
}
