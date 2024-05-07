package com.example.springboot.controller;

import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;
import com.example.springboot.service.UserService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List; // Import List
import java.util.NoSuchElementException;

@RestController
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;



    @Autowired
    public UserController(UserService userService, UserRepository userRepository){
        this.userService = userService;
        this.userRepository =userRepository;
    }


    //display all the users
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User>user = userRepository.findAll();// Change the return type to List<User>
        return new ResponseEntity<>(user,HttpStatus.OK); // Return List<User>
    }


    //display all the users based on id
    //ResponseEntity EXception Handler

    @GetMapping("/users/{id}")
    public  ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        try{
            User user =userService.getUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        catch (NoSuchElementException elementException){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //add users
    @PostMapping("/add")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    //update the users setails based on id
    @PutMapping("/update/{id}")
    public void updateUserById(@PathVariable("id") int id, @RequestBody User user){
        user.setId(id);
        userService.updateUser(id,user);
    }

    //Delete the users based on id
    @DeleteMapping("/delete/{id}")
    public void deleteUSerById(@PathVariable("id") int id){
         userService.deleteUserById(id);
    }
}
