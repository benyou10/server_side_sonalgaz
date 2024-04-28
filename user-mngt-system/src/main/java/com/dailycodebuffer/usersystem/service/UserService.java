package com.dailycodebuffer.usersystem.service;

import com.dailycodebuffer.usersystem.model.Employee;

import java.util.List;

public interface UserService {
    Employee saveUser(Employee user);
    List<Employee> getAllUsers();

    Employee getUserById(int id);

    boolean deleteUser(int id);

    Employee upddateUser(int id, Employee user);
}
