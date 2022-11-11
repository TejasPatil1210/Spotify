package com.tejas.spotifysongservice.service;

import com.tejas.spotifysongservice.domain.Song;
import com.tejas.spotifysongservice.exception.SongAlreadyExistException;
import com.tejas.spotifysongservice.exception.SongNotFoundException;

import java.util.List;
import java.util.Optional;

public interface SongService {
    Song saveSong(Song song) throws SongAlreadyExistException;
    List<Song> getAllSongs();

    Song getSong(String songName) throws SongNotFoundException;
}
