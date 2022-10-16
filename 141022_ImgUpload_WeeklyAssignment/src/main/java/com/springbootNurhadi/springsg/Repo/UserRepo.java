package com.springbootNurhadi.springsg.Repo;

import com.springbootNurhadi.springsg.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Integer> {
    // 1st Argument = Model, 2nd Argument = ID
    // User Repository to execute the User Model with the data type of Entity
    // Connection between Service Layer and the Model

    @Query("select userModel from UserModel userModel where email = ?1 and password = ?2")
    Optional<UserModel> getUserByEmailAndPassword (String email, String password);

     @Query("select userModel from UserModel userModel where email = ?1")
     Optional<UserModel> getValidEmail (String email);

    @Modifying
    @Transactional
    @Query ("Update UserModel set token = ?1 where id = ?2")
    Integer updateTokenUsingUserId (String token, Integer id);

    @Modifying
    @Transactional
    @Query("update UserModel set img = ?1 where id = ?2")
    Integer uploadImgDatabase (String img, Integer id);

//    @Query("select userModel from UserModel userModel where email = ?1")
//    Optional<UserModel> getUserByEmail (String email);
//
//    @Query("select userModel from UserModel userModel")
//    List<UserModel> getAllUser();
}
