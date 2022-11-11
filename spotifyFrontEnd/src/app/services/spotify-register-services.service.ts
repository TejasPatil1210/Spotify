import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserRegInput } from '../modelClasses/UserRegInput';
@Injectable({
  providedIn: 'root'
})
export class SpotifyRegisterServicesService {

  constructor(private http:HttpClient) { }
  // "http://localhost:8089/api/v1/user-song-service/user";
  regapi="http://localhost:9000/api/v1/user-song-service/user";
  getapi="http://localhost:9000/api/v1/user-song-service/users";  
  registerdata(data:any):Observable<UserRegInput>
  {
    return this.http.post<UserRegInput>(this.regapi,data,{responseType:'text' as 'json'})
  }

  getRegData()
  {
    return this.http.get(this.regapi)
  }
}
