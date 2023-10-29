package com.apify.crud_users.services;

import com.apify.crud_users.models.User;
import com.apify.crud_users.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;

    public ArrayList<User> getUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public Optional<User> getById(String id){
        return userRepository.findById(id);
    }

    public Boolean deleteUser (String id){
        try {
            userRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
