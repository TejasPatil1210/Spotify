import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CheckAuthUserService {

  constructor() { }
  authorizeUser:boolean=false;
 // redirectedUrl:any | null=null;

  CheckAuthorizeUser()
  {
    return this.authorizeUser;
  }


}
