package com.apify.crud_users.repositories;

import com.apify.crud_users.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, String> {
   // ArrayList<UserModel>
}
