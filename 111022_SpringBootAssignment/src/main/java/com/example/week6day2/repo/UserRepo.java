package com.example.week6day2.repo;

import com.example.week6day2.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Integer> { //1st Argument = Model, 2nd Argument = ID
// User Repository to execute the User Model with the data type of Entity
    // Connection between Service Layer and the Model
}
