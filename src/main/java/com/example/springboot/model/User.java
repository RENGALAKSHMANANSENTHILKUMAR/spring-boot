package com.example.springboot.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;


public class User {



    private int id;
    private String username;
    private String department;
    private Double salary;

    public User(){

    }

    public User(String username, String department, Double salary) {
        this.username = username;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
