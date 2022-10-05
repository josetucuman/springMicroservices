package com.vyjsoftware.controller;

import com.vyjsoftware.dto.UserDTO;
import com.vyjsoftware.entity.UserEntity;
import com.vyjsoftware.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> getAll(){
        List<UserEntity> users = userService.getAll();
        if(!users.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(users);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Integer idUser) {
        UserEntity user = userService.getUserById(idUser);
        if(user!= null){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/users")
    public ResponseEntity<UserEntity> addUser(@RequestBody UserDTO user) {
        UserEntity userEntity = new UserEntity();

        if(user!= null){
            BeanUtils.copyProperties(user, userEntity);
            userService.save(userEntity);
            return ResponseEntity.ok(userEntity);
        }
        return ResponseEntity.unprocessableEntity().build();
    }
}
