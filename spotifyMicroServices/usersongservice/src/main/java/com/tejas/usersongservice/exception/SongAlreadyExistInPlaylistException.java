package com.tejas.usersongservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Song already exist in playlist")
public class SongAlreadyExistInPlaylistException extends Exception{
}
