import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Song } from '../modelClasses/Song';
@Injectable({
  providedIn: 'root'
})
export class SpotifySongService {
  constructor(private http:HttpClient) { }
  getSongApi="http://localhost:9000/api/v3/spotify-songs/songs";
  getapi="http://localhost:9000/api/v1/user-song-service/users";  
  // registerdata(data:any):Observable<UserRegInput>
  // {
  //   return this.http.post<UserRegInput>(this.regapi,data,{responseType:'text' as 'json'})
  // }

  getSongData()
  {
    return this.http.get<Song[]>(this.getSongApi)
  }
  
}
