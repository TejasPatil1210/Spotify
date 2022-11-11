package com.tejas.usersongservice.service;

import com.tejas.usersongservice.domain.Playlist;
import com.tejas.usersongservice.domain.Song;
import com.tejas.usersongservice.domain.User;
import com.tejas.usersongservice.exception.*;
import com.tejas.usersongservice.proxy.UserProxy;
import com.tejas.usersongservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    private UserProxy userProxy;

    @Autowired
    public UserServiceImpl(UserProxy userProxy,UserRepository userRepository)
    {
        this.userProxy = userProxy;
        this.userRepository = userRepository;
    }

    @Override
    public User saveUserDetails(User user) throws UserAlreadyRegisteredException {
        if(userRepository.findById(user.getUserEmail()).isPresent())
        {
            throw new UserAlreadyRegisteredException();
        }
        ResponseEntity<?> response=userProxy.registerUser(user);
        if(response.getStatusCodeValue()==201)
        {
            return userRepository.save(user);
        }
        else return null;
    }

    @Override
    public User createPlaylist(String userEmail, Playlist playlist) throws UserNotFoundException, PlaylistAlreadyExistException {

        if(userRepository.findById(userEmail).isEmpty())
        {
            System.out.println("************");
            throw new UserNotFoundException();
        }
        Optional<User> user=userRepository.findById(userEmail);
        User user1=user.get();
        List<Playlist> playlists;
        if(user1.getPlaylists()==null)
        {
            playlists=new ArrayList<>();
        }
        else
        {
            playlists=user1.getPlaylists();
            for(Playlist playlist1:playlists)
            {
                if(playlist1.getPlayListName().equals(playlist.getPlayListName()))
                {
                    System.out.println("playlist already exist");
                    throw new PlaylistAlreadyExistException();
                }
            }
        }
        System.out.println("hello");
        System.out.println(playlist.getPlayListName());
        playlists.add(playlist);
        user1.setPlaylists(playlists);
        return userRepository.save(user1);
    }

    @Override
    public User saveSongInPlaylist(String userEmail, String playListName, Song song) throws PlaylistNotFoundException, UserNotFoundException, SongAlreadyExistInPlaylistException {
        if(userRepository.findById(userEmail).isEmpty())
        {
            throw new UserNotFoundException();
        }
//        ResponseEntity<?> 
        User user1=userRepository.findById(userEmail).get();
//        User user1=user.get();
        List<Playlist> playlists=user1.getPlaylists();
        Playlist playlist1=new Playlist();
        for (Playlist playlist:playlists)
        {
            if(playlist.getPlayListName().equals(playListName))
            {
                playlist1=playlist;break;
            }
            else {
                playlist1=null;
            }
        }
        if(playlist1==null)
        {
            throw new PlaylistNotFoundException();
        }
        else
        {
            List<Song> songList;
            if(playlist1.getSongsList()==null)
            {
                songList=new ArrayList<>();
            }
            else {
                songList = playlist1.getSongsList();

                for (Song songs : songList) {
                    if (songs.getSongName().equals(song.getSongName())) {
                        throw new SongAlreadyExistInPlaylistException();
                    }
                }
            }
            songList.add(song);
            playlist1.setSongsList(songList);
//          user1.setPlaylists(playlists);
        }
        return userRepository.save(user1);
    }

    @Override
    public User getUserDetails(String userEmail) throws UserNotFoundException {
        if(userRepository.findById(userEmail).isEmpty())
        {
            throw new UserNotFoundException();
        }
        User user=userRepository.findById(userEmail).get();
        return user;
    }

    @Override
    public User findByUserEmailAndPlayListName(String userEmail, String playListName) throws  PlaylistNotFoundException {
        User playlist=(userRepository.findByUserEmailAndPlayListName(userEmail,playListName));
        if(playlist==null)
        {
            throw new PlaylistNotFoundException();
        }
        return playlist;
    }
}
