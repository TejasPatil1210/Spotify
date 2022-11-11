package com.tejas.usersongservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "User Already exist")
public class UserAlreadyRegisteredException extends Exception{
}
