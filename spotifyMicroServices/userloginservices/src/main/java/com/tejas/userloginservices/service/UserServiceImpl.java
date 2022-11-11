package com.tejas.userloginservices.service;

import com.tejas.userloginservices.domain.User;
import com.tejas.userloginservices.exception.UserAlreadyRegisteredException;
import com.tejas.userloginservices.exception.UserNotFoundException;
import com.tejas.userloginservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) throws UserAlreadyRegisteredException {
        if(userRepository.findById(user.getUserEmail()).isPresent())
        {
            throw new UserAlreadyRegisteredException();
        }
        return userRepository.save(user);
    }

    @Override
    public User findByUserEmailAndPassword(String userEmail, String password) throws UserNotFoundException {
        return userRepository.findByUserEmailAndPassword(userEmail,password);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
