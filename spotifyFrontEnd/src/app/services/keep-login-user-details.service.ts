import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class KeepLoginUserDetailsService {

  constructor() { }
  userLoginDetails:any
  plname:any
  getUserLoginDetails()
  {
    return this.userLoginDetails;
  }

  getPlName()
  {
    return this.plname;
  }
}
