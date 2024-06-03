package com.dailycodebuffer.usersystem.service;

import com.dailycodebuffer.usersystem.model.*;
import com.zkteco.commands.UserInfo;

import java.io.IOException;
import java.util.List;

public interface UserService {
    Employee saveUser(Employee user);
    List<Employee> getAllUsers();
    List<Employee> getAllUsersInDepartment(int i);
    int updateRcByID(int id);
    TimeOff searchForTimeOffById(int id);

    Employee getUserById(int id);
    List<Archive> getAllNewArchivesInDepartment(int id);

    UserInfo saveUserinDevice(UserInfo user) throws IOException;
    boolean deleteUser(int id);
    List<TimeOff> searchForTimeOff();
    Employee upddateUser(int id, Employee user);
    Boolean upddatePassword(int id, PasswordChange user);
}
