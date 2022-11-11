package com.tejas.userloginservices.service;

import com.tejas.userloginservices.domain.User;
import com.tejas.userloginservices.exception.UserAlreadyRegisteredException;
import com.tejas.userloginservices.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    User saveUser(User user) throws UserAlreadyRegisteredException;
    User findByUserEmailAndPassword(String userEmail,String password) throws UserNotFoundException;

    List<User> getAllUsers();
}
