package com.example.springboot.controller;

import com.example.springboot.model.User;
import com.example.springboot.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List; // Import List

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() { // Change the return type to List<User>
        return userService.getAllUsers(); // Return List<User>
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping("/updatesalary/{id}")
    public void updateUsersalaryById(@PathVariable("id") int id, @RequestBody User user){
        user.setId(id);
        userService.updateUser(id,user);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteUSerById(@PathVariable("id") int id){
         userService.deleteUserById(id);
    }
}
