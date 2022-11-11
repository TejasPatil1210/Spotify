import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserLoginInput } from '../modelClasses/UserLoginInput';


@Injectable({
  providedIn: 'root'
})
export class SpotifyLoginServiceService {

  constructor(private http:HttpClient) { }
  //regapi="http://localhost:4000/register";
  //authapi="http://localhost:4000/authenticate";
  // "http://localhost:8085/api/v2/user-login/login"
  authapi="http://localhost:9000/api/v2/user-login/login"


// storeAuthData(authdata:any)
// {
//   return this.http.post(this.authapi,authdata)
// }

// gedata()
// {
//   return this.http.get(this.authapi);
// }


logindata(cData:any):Observable<UserLoginInput>
{
   console.log("hiii"+cData.userEmail)
  return this.http.post<UserLoginInput>(this.authapi,cData)
}


}
