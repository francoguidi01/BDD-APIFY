package com.apify.crud_users.services;

import com.apify.crud_users.models.UserModel;
import com.apify.crud_users.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;

    public ArrayList<UserModel> getUsers() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }
    public  UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }
    public Optional<UserModel> getById(Long id){
        return userRepository.findById(id);
    }

    public Boolean deleteUser (Long id){
        try {
            userRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
