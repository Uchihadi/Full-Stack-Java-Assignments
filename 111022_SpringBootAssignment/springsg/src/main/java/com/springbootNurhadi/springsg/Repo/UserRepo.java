package com.springbootNurhadi.springsg.Repo;

import com.springbootNurhadi.springsg.model.UserModel;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Integer> {
    //1st Argument = Model, 2nd Argument = ID
    // User Repository to execute the User Model with the data type of Entity
    // Connection between Service Layer and the Model

    @Query ("Select Users From UserModel Users where email = ?1 and password = ?2")
    Optional<UserModel> getUserByEmailAndPassword (String email, String password);

    @Query("select user from UserModel user where email = ?1")
    Optional<UserModel> getValidEmail(String email);

    @Modifying
    @Transactional
    @Query ("Update UserModel set token = ?1 where ID = ?2")
    Integer updateTokenUsingUserId(String token, Integer id);
}
