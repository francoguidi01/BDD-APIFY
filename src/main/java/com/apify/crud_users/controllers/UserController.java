package com.apify.crud_users.controllers;

import com.apify.crud_users.models.User;
import com.apify.crud_users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
   @Autowired
    private UserService userService;
    //@CrossOrigin(origins = "http://127.0.0.1:5500/index.html")
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/get-all-users")
    public ArrayList<User> getUsers() {
        return this.userService.getUsers();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add")
    public ResponseEntity<User> setUser(@RequestBody User user) {
        Optional<User> existingUser = userService.getById(user.getId());
        if (existingUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        } else {
            User savedUser = userService.saveUser(user);
            return ResponseEntity.ok(savedUser);
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/get-an-user/{id}")
    public Optional<User> getUserById(@PathVariable("id") String id) {
        return this.userService.getById(id);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "/delete/{id}")
    public String deleteById(@PathVariable("id") String id) {
        boolean deleted = this.userService.deleteUser(id);
        if (deleted) {
            return "user was deleted";
        } else {
            return "ERROR: user was not deleted";
        }
    }

}
