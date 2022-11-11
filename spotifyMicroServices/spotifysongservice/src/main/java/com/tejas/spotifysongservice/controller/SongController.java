package com.tejas.spotifysongservice.controller;

import com.tejas.spotifysongservice.domain.Song;
import com.tejas.spotifysongservice.exception.SongAlreadyExistException;
import com.tejas.spotifysongservice.exception.SongNotFoundException;
import com.tejas.spotifysongservice.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v3/spotify-songs")
public class SongController {
    private SongService service;
    private ResponseEntity responseEntity;

    @Autowired
    public SongController(SongService service) {
        this.service = service;
    }

    @PostMapping("/song")
    public ResponseEntity saveSong(@RequestBody Song song) throws SongAlreadyExistException
    {
        try{
            service.saveSong(song);
            responseEntity=new ResponseEntity(song, HttpStatus.CREATED);
        }
        catch (SongAlreadyExistException sae)
        {
            throw sae;
        }
        catch (Exception e )
        {
            responseEntity=new ResponseEntity("Error!!! Try After SomeTime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/songs")
    public ResponseEntity getAllSongs()
    {
        List<Song> songs=service.getAllSongs();
        responseEntity=new ResponseEntity(songs,HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/song/{songName}")
    public ResponseEntity getSong(@PathVariable("songName") String songName) throws SongNotFoundException
    {
        System.out.println(songName);
        try {
            Song song = service.getSong(songName);
            responseEntity = new ResponseEntity(song, HttpStatus.OK);
        }
        catch (SongNotFoundException s)
        {
            throw new SongNotFoundException();
        }
        catch (Exception e)
        {
            responseEntity=new ResponseEntity("Error!!! Try After SomeTime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
