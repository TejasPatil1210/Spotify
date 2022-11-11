package com.tejas.usersongservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Playlist Not Found")
public class PlaylistNotFoundException extends Exception{
}
