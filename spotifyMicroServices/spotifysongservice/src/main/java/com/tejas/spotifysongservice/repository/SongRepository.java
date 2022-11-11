package com.tejas.spotifysongservice.repository;

import com.tejas.spotifysongservice.domain.Song;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SongRepository extends MongoRepository<Song,String> {

}
