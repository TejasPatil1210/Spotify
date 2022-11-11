package com.tejas.usersongservice.service;

import com.tejas.usersongservice.domain.Playlist;
import com.tejas.usersongservice.domain.Song;
import com.tejas.usersongservice.domain.User;
import com.tejas.usersongservice.exception.*;

import java.util.List;

public interface UserService {
    User saveUserDetails(User user) throws UserAlreadyRegisteredException;
    User createPlaylist(String userEmail,Playlist playlist) throws UserNotFoundException, PlaylistAlreadyExistException;
    User saveSongInPlaylist(String userEmail,String playlistName,Song song) throws PlaylistNotFoundException,UserNotFoundException, SongAlreadyExistInPlaylistException;

    User getUserDetails(String userEmail) throws UserNotFoundException;
    User findByUserEmailAndPlayListName(String userEmail,String playListName) throws PlaylistNotFoundException;
}
