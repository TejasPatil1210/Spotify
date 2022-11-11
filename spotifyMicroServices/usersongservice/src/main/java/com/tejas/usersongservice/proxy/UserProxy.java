package com.tejas.usersongservice.proxy;

import com.tejas.usersongservice.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "LOGIN-SERVICE")

public interface UserProxy {
    @PostMapping("api/v2/user-login/register")
    ResponseEntity registerUser(@RequestBody User user);
}
