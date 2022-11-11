package com.tejas.userloginservices.service;

import com.tejas.userloginservices.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String,String> generateToken(User user);
}
