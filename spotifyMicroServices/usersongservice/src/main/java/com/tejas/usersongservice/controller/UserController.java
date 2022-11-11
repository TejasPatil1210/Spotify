package com.tejas.usersongservice.controller;

import com.tejas.usersongservice.domain.Playlist;
import com.tejas.usersongservice.domain.Song;
import com.tejas.usersongservice.domain.User;
import com.tejas.usersongservice.exception.*;
import com.tejas.usersongservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import java.util.List;
import java.util.stream.Collectors;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/user-song-service")
//http://localhost:9000/api/v1/user-song-service/user
public class UserController {
    private ResponseEntity responseEntity;
    private UserService userService;

    @Autowired

    public UserController(UserService userService) {this.userService = userService;}
    //@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/user")
    public ResponseEntity saveUser(@RequestBody User user) throws UserAlreadyRegisteredException
    {
        try {
            userService.saveUserDetails(user);
            responseEntity=new ResponseEntity(user, HttpStatus.CREATED);
        }
        catch (UserAlreadyRegisteredException uar)
        {
            throw uar;
        }
        catch (Exception e)
        {
            responseEntity=new ResponseEntity("Error!!! Try after sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PostMapping("/{userEmail}/playlist")
    public ResponseEntity createPlaylist(@RequestBody Playlist playlist, @PathVariable String userEmail) throws UserNotFoundException, PlaylistAlreadyExistException
    {
        System.out.println(playlist.getPlayListName());
        try
        {
            System.out.println("try");
            userService.createPlaylist(userEmail,playlist);
            responseEntity=new ResponseEntity(playlist,HttpStatus.CREATED);
        }catch (UserNotFoundException unf)
        {
            System.out.println("catch1");
            throw unf;
        }
        catch (PlaylistAlreadyExistException pla)
        {
            System.out.println("catch2");
            throw pla;
        }
        catch (Exception e)
        {
            System.out.println("catch3");
            e.printStackTrace();
            responseEntity=new ResponseEntity("Error!!! Try after sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PostMapping("/song/{userEmail}/{playListName}")
    public ResponseEntity saveSong(@PathVariable String userEmail, @PathVariable String playListName, @RequestBody Song song) throws PlaylistNotFoundException,UserNotFoundException, SongAlreadyExistInPlaylistException
    {
        System.out.println(userEmail);
        System.out.println(song.getSongName());

        try{
            System.out.println("hiiiii");
            userService.saveSongInPlaylist(userEmail,playListName,song);
            responseEntity=new ResponseEntity(song,HttpStatus.CREATED);
        }
        catch (UserNotFoundException unf)
        {
            throw unf;
        }
        catch (PlaylistNotFoundException pnf)
        {
            throw pnf;
        }
        catch (SongAlreadyExistInPlaylistException sae)
        {
            throw sae;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            responseEntity=new ResponseEntity<>("Error!!! Try after sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/user/{userEmail}")
    public ResponseEntity getUserDetail(@PathVariable("userEmail") String userEmail) throws UserNotFoundException
    {
        try
        {
            User user=userService.getUserDetails(userEmail);
            responseEntity=new ResponseEntity<>(user,HttpStatus.OK);
        }
        catch (UserNotFoundException unf)
        {
            throw new UserNotFoundException();
        }
        catch (Exception e)
        {
            responseEntity=new ResponseEntity("Error!!! Try After Sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/user/{userEmail}/{playListName}")
    public ResponseEntity getPlayListDetails(@PathVariable("playListName") String playListName,@PathVariable("userEmail") String userEmail) throws PlaylistNotFoundException
    {
        try {
         List<Playlist> playlists = userService.findByUserEmailAndPlayListName(userEmail,playListName).getPlaylists();
         Playlist playlist=playlists.stream().filter(x->x.getPlayListName().equals(playListName)).findAny().get();
         playlists.forEach(x-> System.out.println(x));
                responseEntity=new ResponseEntity(playlist,HttpStatus.OK);
        }
        catch (PlaylistNotFoundException unf)
        {
            throw new PlaylistNotFoundException();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            responseEntity=new ResponseEntity("Error!!! Try After Sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
