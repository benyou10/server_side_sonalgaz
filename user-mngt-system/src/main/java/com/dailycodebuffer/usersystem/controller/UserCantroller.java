package com.dailycodebuffer.usersystem.controller;

import com.dailycodebuffer.usersystem.model.Employee;
import com.dailycodebuffer.usersystem.service.UserService;
import jakarta.persistence.Id;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UserCantroller {
    private final UserService userService;

    public UserCantroller(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/users")
    public Employee saveUser(@RequestBody Employee user){
       return userService.saveUser(user);
    }
    @GetMapping("/users")
    public List<Employee> getAllUsers(){
    return  userService.getAllUsers();
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<Employee> getUserById(@PathVariable("id") int id){
        Employee user=null;
        user =userService.getUserById(id);
        return  ResponseEntity.ok(user);
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteUser(@PathVariable("id") int id){
        boolean deleted=false;
        deleted= userService.deleteUser(id);
        Map<String,Boolean> response= new HashMap<>();
        response.put("deleted",deleted);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<Employee> updateUser(@PathVariable("id") int id,
                                           @RequestBody Employee user){
        user =userService.upddateUser(id, user);
        return ResponseEntity.ok(user);
    }


}
