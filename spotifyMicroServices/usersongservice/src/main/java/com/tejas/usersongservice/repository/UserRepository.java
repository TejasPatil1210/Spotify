package com.tejas.usersongservice.repository;

import com.tejas.usersongservice.domain.Playlist;
import com.tejas.usersongservice.domain.User;
import com.tejas.usersongservice.exception.PlaylistNotFoundException;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User,String> {
//    {'user.userEmail':[?0]},{'user.playlists':{$elemMatch:{ 'user.playlists.playListName':[?1]}}},{'user.playlists':0,'user.playlists.playListName':1,'SongsList':1,_id:0}
    //value = "{'userEmail': [?0] },{'playlists':{$elemMatch:{'playListName': [?1] }}}",fields = "{'playlists':1,'playListName':1,'SongsList':1,userEmail:0}"
//{'userEmail':?0},{'playlists':{$elemMatch:{ 'playListName':?1}}},{'playlists':1,'playListName':1,'SongsList':1,'userEmail':0}
    @Query(value = "{'userEmail': ?0 },{'playlists':{$elemMatch:{'playListName': ?1 }}}",fields = "{'playlists':1,'playListName':1,'SongsList':1,userEmail:0}")
    User findByUserEmailAndPlayListName(String userEmail,String playListName) throws PlaylistNotFoundException;
}
