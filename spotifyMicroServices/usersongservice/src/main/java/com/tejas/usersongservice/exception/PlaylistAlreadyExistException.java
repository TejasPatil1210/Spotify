package com.tejas.usersongservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Playlist already exist")
public class PlaylistAlreadyExistException extends Exception{
}
