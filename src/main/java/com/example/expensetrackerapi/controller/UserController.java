package com.example.expensetrackerapi.controller;

import com.example.expensetrackerapi.model.User;
import com.example.expensetrackerapi.model.UserModel;
import com.example.expensetrackerapi.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class UserController {
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> save(@Valid @RequestBody UserModel user){
        return new ResponseEntity<>(userService.createUser(user),
                HttpStatus.CREATED);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<User> read(@PathVariable Long id) throws Exception{
        return new ResponseEntity<>(userService.getUser(id),
                HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@PathVariable Long id,@RequestBody UserModel user) throws Exception{
        return new ResponseEntity<>(userService.updateUser(id,user),
                HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
