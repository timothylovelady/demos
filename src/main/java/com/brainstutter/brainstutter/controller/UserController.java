package com.brainstutter.brainstutter.controller;


import com.brainstutter.brainstutter.model.User;
import com.brainstutter.brainstutter.model.UserDTO;
import com.brainstutter.brainstutter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/user/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<User>> allUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserDTO> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }
    @PostMapping(value = "/user/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserDTO> create (@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }
    @DeleteMapping("/user/{id}")
    ResponseEntity<String> delete (@PathVariable Integer id) {
        return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);
    }
}
