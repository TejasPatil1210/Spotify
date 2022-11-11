package com.tejas.userloginservices.repository;

import com.tejas.userloginservices.domain.User;
import com.tejas.userloginservices.exception.UserNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    public User findByUserEmailAndPassword(String userEmail,String password) throws UserNotFoundException;
}
