import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CheckAuthUserService } from '../services/check-auth-user.service';
import { KeepLoginUserDetailsService } from '../services/keep-login-user-details.service';
import { SpotifyLoginServiceService } from '../services/spotify-login-service.service';

@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent implements OnInit {

  loginForm:FormGroup
  constructor(private loginservice:SpotifyLoginServiceService,private route:Router,private userdtsev:KeepLoginUserDetailsService,
    private checkAuth:CheckAuthUserService) {
    this.loginForm=new FormGroup({
      userEmail:new FormControl('',[Validators.required]),
      password:new FormControl('',[Validators.required])
    })
   }
  //  private mailogserv:MailschloginService,,private authservice:AuthService

  ngOnInit(): void {
  }

  login()
  {
    this.loginservice.logindata(this.loginForm.value).subscribe((x)=>
    {
      console.log(x)
      console.log(x.userEmail)
      this.checkAuth.authorizeUser=true;
      this.userdtsev.userLoginDetails=x;
      this.route.navigate(['home'])
    },
    ()=>{
      alert("Invalid Username or Password ");
      // this.route.navigate(['/accounts/register'])
      })
  }
}
