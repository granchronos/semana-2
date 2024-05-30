package com.idat.semana2.service;

import com.idat.semana2.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void save(User user);

    List<User> findAll();

    Optional<User> findById(Long id);

}
