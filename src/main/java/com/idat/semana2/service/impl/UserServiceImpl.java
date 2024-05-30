package com.idat.semana2.service.impl;

import com.idat.semana2.model.User;
import com.idat.semana2.repository.UserRepository;
import com.idat.semana2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return StreamSupport.stream(this.userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(Long id) {
        return this.userRepository.findById(id);
    }
}
