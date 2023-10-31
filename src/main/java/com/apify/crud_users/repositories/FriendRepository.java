package com.apify.crud_users.repositories;

import com.apify.crud_users.models.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, Integer> {
    List<Friend> findByUser1Id(String userId1);
    List<Friend> findByUser2Id(String userId2);
}