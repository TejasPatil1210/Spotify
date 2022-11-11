import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PlayList } from '../modelClasses/PlayList';
import { Song } from '../modelClasses/Song';

@Injectable({
  providedIn: 'root'
})
export class GetUserSongDataService {

  constructor(private http:HttpClient) { }

  userSongapi="http://localhost:9000/api/v1/user-song-service/user"; 
  userPlaylistapi="http://localhost:9000/api/v1/user-song-service"; 
  getUserData(userEmail:any)
  {
    return this.http.get<any>(`${this.userSongapi}/${userEmail}`)
  }

  getPlaylistData(userEmail:any,playListName:any)
  {
    console.log(userEmail+" "+playListName)
    return this.http.get<any>(`${this.userSongapi}/${userEmail}/${playListName}`)
  }

  createPlayList(userEmail:any,plList:PlayList)
  {
     
    return this.http.post<PlayList>(this.userPlaylistapi+`/${userEmail}/playlist`,plList)
  }
  addSongsInPlaylist(userEmail:any,plList:any,songs:Song)
  {
    console.log(userEmail)
    console.log(plList)
    console.log(songs)
    return this.http.post<any>(this.userPlaylistapi+`/song/${userEmail}/${plList}`,songs)
  }
}
