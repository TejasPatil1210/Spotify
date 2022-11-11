import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SpotifyChkPassServiceService {

  constructor() { }
  password:any
  confPassword:any

  getpasswd()
  {
    return this.password
  }

  getConfpasswd()
  {
    return this.confPassword
  }
}
