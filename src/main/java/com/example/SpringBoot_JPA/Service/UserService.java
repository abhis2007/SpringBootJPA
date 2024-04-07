package com.example.SpringBoot_JPA.Service;

import com.example.SpringBoot_JPA.Model.UserRecord;
import com.example.SpringBoot_JPA.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo ;

    public List<UserRecord> getAllUsers() {
        List<UserRecord> users = new ArrayList<UserRecord>() ;
        userRepo.findAll().forEach(users::add) ;

        return users ;
    }

    public UserRecord getUserById(int id) {
        return userRepo.findById(id).get() ;
    }

    public void addUser(UserRecord user) {
        userRepo.save(user) ;
    }
}
