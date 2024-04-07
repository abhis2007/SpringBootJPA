package com.example.SpringBoot_JPA.Controller;

import com.example.SpringBoot_JPA.Model.UserRecord;
import com.example.SpringBoot_JPA.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService ;

    @GetMapping("/")
    public List<UserRecord> getAllUsers() {
        return userService.getAllUsers() ;
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody UserRecord user) {
        userService.addUser(user);
    }

    @GetMapping("/getById")
    public UserRecord getById(@RequestParam int id) {
        return userService.getUserById(id) ;
    }
}
