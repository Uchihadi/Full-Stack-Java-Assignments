package com.springbootNurhadi.springsg.Repo;

import com.springbootNurhadi.springsg.model.UserModel;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserModel,Integer> {
    @Query("select user from UserModel user where email = ?1 and password=?2")
    Optional<UserModel> getUserByEmailAndPassword(String email, String password);
    /*
    DML error
     */
    @Modifying
    @Transactional
    @Query("update  UserModel  set token = ?1 gg where id = ?2")
    Integer updateTokenForUserId(String token, Integer userId);

    @Query("select user from UserModel user where email = ?1")
    Optional<UserModel> getUserByEmail(String email);
    //    @Query("select count(user) from UserModel user ")
//   Integer getUsercount();
    @Query("select user from UserModel user ")
    List<UserModel> getAllUser();

}