package com.tejas.spotifysongservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT,reason = "Song already Exist")
public class SongAlreadyExistException extends Exception{
}
