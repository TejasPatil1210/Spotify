package com.tejas.spotifysongservice.service;

import com.tejas.spotifysongservice.domain.Song;
import com.tejas.spotifysongservice.exception.SongAlreadyExistException;
import com.tejas.spotifysongservice.exception.SongNotFoundException;
import com.tejas.spotifysongservice.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService{
    private SongRepository songRepository;

    @Autowired
    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public Song saveSong(Song song) throws SongAlreadyExistException {
        if(songRepository.findById(song.getSongName()).isPresent())
        {
            throw new SongAlreadyExistException();
        }
        return songRepository.save(song);
    }

    @Override
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public Song getSong(String songName) throws SongNotFoundException {
            if(songRepository.findById(songName).isEmpty())
            {
                System.out.println("inside try");
                throw new SongNotFoundException();
            }
        System.out.println("hiiiiii"+songName);
        Song song=songRepository.findById(songName).get();
           return song;
    }
}
