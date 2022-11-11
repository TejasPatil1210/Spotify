package com.tejas.userloginservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "User Already Registered")
public class UserAlreadyRegisteredException extends Exception{
}
