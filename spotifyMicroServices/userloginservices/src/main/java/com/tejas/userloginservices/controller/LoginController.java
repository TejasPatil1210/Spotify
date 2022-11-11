package com.tejas.userloginservices.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tejas.userloginservices.domain.User;
import com.tejas.userloginservices.exception.UserAlreadyRegisteredException;
import com.tejas.userloginservices.exception.UserNotFoundException;
import com.tejas.userloginservices.service.SecurityTokenGenerator;
import com.tejas.userloginservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v2/user-login")
public class LoginController {
    private UserService userService;
    private ResponseEntity responseEntity;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public LoginController(UserService userService, SecurityTokenGenerator securityTokenGenerator) {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }
   // @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody User user) throws UserAlreadyRegisteredException
    {
        userService.saveUser(user);
        responseEntity=new ResponseEntity<>("User Created", HttpStatus.CREATED);
        return responseEntity;
    }
    //@CrossOrigin(origins = "http://localhost:4200")

    @PostMapping("/login")
    @HystrixCommand(fallbackMethod = "fallbackLogin")
    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="80000")
    public ResponseEntity userLogin(@RequestBody User user) throws UserNotFoundException
    {
        Map<String,String>map=null;
        try
        {
            User user1=userService.findByUserEmailAndPassword(user.getUserEmail(),user.getPassword());
            if(user1.getUserEmail().equals(user.getUserEmail()))
            {
                map=securityTokenGenerator.generateToken(user);
                responseEntity=new ResponseEntity(map,HttpStatus.OK);
            }
        }catch (UserNotFoundException unf)
        {
            throw unf;
//            responseEntity=new ResponseEntity(unf.getMessage(),HttpStatus.CONFLICT);
        }
        catch (Exception e)
        {
            responseEntity=new ResponseEntity("Try After Sometime!!!",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    public ResponseEntity<?>fallbackLogin(@RequestBody User user)
    {
        String msg="login failed!!! Try After Sometime!!!";
        return new ResponseEntity<>(msg,HttpStatus.GATEWAY_TIMEOUT);
    }

    @GetMapping("/users")
    public ResponseEntity getAllUsers()
    {
        List<User> users=userService.getAllUsers();
        return new ResponseEntity(users,HttpStatus.OK);
    }

}
