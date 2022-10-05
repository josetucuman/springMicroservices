package com.vyjsoftware.service;

import com.vyjsoftware.entity.UserEntity;
import com.vyjsoftware.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(Integer idUser){
        return userRepository.findById(idUser).orElse(null);
    }

    public UserEntity save(UserEntity newUser){
        UserEntity  nuevoEmpleado = userRepository.save(newUser);
        return nuevoEmpleado;
    }
}
