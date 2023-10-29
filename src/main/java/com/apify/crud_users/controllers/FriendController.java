package com.apify.crud_users.controllers;

import com.apify.crud_users.models.Friend;
import com.apify.crud_users.models.User;
import com.apify.crud_users.repositories.IUFriendRepository;
import com.apify.crud_users.repositories.IUserRepository;
import com.apify.crud_users.services.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/friends")
@CrossOrigin(origins = "*")
public class FriendController {
    @Autowired
    private IUserRepository iUserRepository;
    @Autowired
    private FriendService friendService;
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/get-friend-requests")
    public ResponseEntity<List<Friend>> getFriendRequests() {
        List<Friend> friendRequests = friendService.getAllFriendRequests();
        return ResponseEntity.ok(friendRequests);
    }
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/get-friend-received")
    public ResponseEntity<List<Friend>> getFriendReceived() {
        List<Friend> friendReceived = friendService.getAllFriendReceived();
        return ResponseEntity.ok(friendReceived);
    }
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/get-friends-by-user/{id}")
    public ResponseEntity<List<Friend>> getFriendsByUser(@PathVariable("id") String id) {
        List<Friend> friends = friendService.getFriendsByUserId(id);
        return ResponseEntity.ok(friends);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add-friend")
    public ResponseEntity<Friend> addFriend(@RequestBody Friend friend) {
        Optional<User> userModelOptional = iUserRepository.findById(friend.getUser1().getId());
        Optional<User> userModelOptional2 = iUserRepository.findById(friend.getUser2().getId());

        if(!userModelOptional.isPresent() && !userModelOptional2.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }

        friend.setUser1(userModelOptional.get());
        friend.setUser2(userModelOptional2.get());

        Friend savedFriend = friendService.saveFriend(friend);
        return ResponseEntity.ok(savedFriend);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "/delete-friend/{id}")
    public ResponseEntity<String> deleteFriend(@PathVariable("id") Integer id) {
        if (friendService.deleteFriend(id)) {
            return ResponseEntity.ok("Friend deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
