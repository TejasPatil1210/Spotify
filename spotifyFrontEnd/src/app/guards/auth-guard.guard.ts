import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { CheckAuthUserService } from '../services/check-auth-user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardGuard implements CanActivate {
  constructor(private authServ:CheckAuthUserService, private route:Router){}
  canActivate(route: ActivatedRouteSnapshot,state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if(this.authServ.CheckAuthorizeUser())
  {
    return true;
  }
  else
  {
    this.route.navigate(['/accounts/login'])
    return false;
  }
  }
}