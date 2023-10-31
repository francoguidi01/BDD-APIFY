package com.apify.crud_users.services;

import com.apify.crud_users.models.Friend;
import com.apify.crud_users.repositories.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {

    @Autowired
    private FriendRepository friendRepository;

    public List<Friend> getAllFriendRequests() {
        return friendRepository.findAll();
    }

    public List<Friend> getAllFriendReceived() {
        return friendRepository.findAll();
    }

    public Friend saveFriend(Friend friend) {
        return friendRepository.save(friend);
    }

    public List<Friend> getFriendsByUserId(String userId) {
        return friendRepository.findByUser1Id(userId);
    }
    public boolean deleteFriend(Integer id) {
        try {
            friendRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
