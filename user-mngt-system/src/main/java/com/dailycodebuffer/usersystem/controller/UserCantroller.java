package com.dailycodebuffer.usersystem.controller;

import com.dailycodebuffer.usersystem.model.*;
import com.dailycodebuffer.usersystem.service.UserService;
import com.zkteco.commands.UserInfo;
import com.zkteco.terminal.ZKTerminal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UserCantroller {
    private final UserService userService;


    public UserCantroller(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public Employee saveUser(@RequestBody Employee user) {
        return userService.saveUser(user);
    }
    @PostMapping("/users/saveindevice")
    public UserInfo saveUserinDevice(@RequestBody UserInfo user) throws IOException {
        return userService.saveUserinDevice(user);
    }

    @GetMapping("/users")
    public List<Employee> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/bydepartment/{id}")
    public List<Employee> getAllUsersInDepartment(@PathVariable("id") int id) {
        return userService.getAllUsersInDepartment(id);
    }
//    @GetMapping("/users/bydepartmentarchivebyday/{id}")
//    public List<Archive> getAllNewArchivesInDepartment(@PathVariable("id") int id) {
//        return userService.getAllNewArchivesInDepartment(id);
//    }


    @GetMapping("/users/{id}")
    public ResponseEntity<Employee> getUserById(@PathVariable("id") int id) {
        Employee user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }
    @GetMapping("/users/{id}/timeoff")
    public ResponseEntity<TimeOff> searchForTimeOffById(@PathVariable("id") int id) {
        TimeOff timeOff = userService.searchForTimeOffById(id);
        if (timeOff == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(timeOff);
    }
    @GetMapping("/users/timeoff")
    public List<TimeOff> searchForTimeOff() {
        return userService.searchForTimeOff();

    }
    @PostMapping ("/users/{id}/rc")
    public int updateRcByID(@PathVariable("id") int id) {

        return userService.updateRcByID(id);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable("id") int id) {
        boolean deleted = userService.deleteUser(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Employee> updateUser(@PathVariable("id") int id, @RequestBody Employee user) {
        Employee updatedUser = userService.upddateUser(id, user);
        if (updatedUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUser);
    }

    @PutMapping("/users/changepassword/{id}")
    public Boolean updatepassword(@PathVariable("id") int id, @RequestBody PasswordChange data) {
        Boolean updatedUser = userService.upddatePassword(id, data);

        return updatedUser;
    }
}
