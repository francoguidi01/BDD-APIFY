package com.apify.crud_users.repositories;

import com.apify.crud_users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {
   // ArrayList<User>
}
