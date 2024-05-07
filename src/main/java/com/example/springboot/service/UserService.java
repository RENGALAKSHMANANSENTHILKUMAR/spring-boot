package com.example.springboot.service;

import com.example.springboot.mapper.Mapper;
import com.example.springboot.model.User;
import org.springframework.stereotype.Service;

import java.util.List; // Import List
import java.util.NoSuchElementException;

@Service
public class UserService {

    private final Mapper userMapper;

    public UserService(Mapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> getAllUsers() { // Return a List<User>
        return userMapper.getAllUsers(); // Change the return type here
    }

    public User getUserById(int id) {
        User olduser = userMapper.getUserById(id);
        if (olduser!=null)
            return userMapper.getUserById(id);
        else
            throw new NoSuchElementException();
    }

    public void addUser(User user){
        userMapper.addUser(user);
    }
    
    public void updateUser(int id, User user){
        User olduser = userMapper.getUserById(id);


        if(user.getName() == null){
            user.setName(olduser.getName());
        }
        if(user.getDepartment() == null){
            user.setDepartment(olduser.getDepartment());
        }
        if(user.getSalary() == null){
            user.setSalary(olduser.getSalary());
        }
        userMapper.updateUser((user));
    }

    public void deleteUserById(int id){
         userMapper.deleteUser(id);
    }
}
