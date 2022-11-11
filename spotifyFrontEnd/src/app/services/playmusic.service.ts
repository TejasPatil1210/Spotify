import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Song } from '../modelClasses/Song';

@Injectable({
  providedIn: 'root'
})
export class PlaymusicService {

  constructor(private http:HttpClient) { }
  getApi="http://localhost:9000/api/v3/spotify-songs/song"

  getData(songName:string | number)
  {
    console.log("in GetData"+songName);
  return this.http.get<Song>(`${this.getApi}/${songName}`) 
  }
}
