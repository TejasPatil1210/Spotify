import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, Validators } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { SpotifyChkPassServiceService } from '../services/spotify-chk-pass-service.service';
import { SpotifyRegisterServicesService } from '../services/spotify-register-services.service';
@Component({
  selector: 'app-register-component',
  templateUrl: './register-component.component.html',
  styleUrls: ['./register-component.component.css']
})
export class RegisterComponentComponent implements OnInit {

  registerForm:FormGroup;
  constructor(private chkpass:SpotifyChkPassServiceService,private routes:Router, private regservice:SpotifyRegisterServicesService) {
    this.registerForm =new FormGroup({
    userEmail:new FormControl('',[Validators.required,validateEmail]),
    phoneNumber:new FormControl('',[Validators.required]),
    password:new FormControl('',[Validators.required,validatePass]),
    confPassword:new FormControl('',[Validators.required,validateconfPass])      
  });
}

// [Validators.required,validateEmail]
// [Validators.required,validatePass]
// [Validators.required,validateconfPass]
// private regservice:MailschloginService,private routes:Router,private chkpass:CheckpasswordService

  ngOnInit(): void {
  }

storeData()
{
  const regData=this.registerForm.value;
  this.regservice.registerdata(regData).subscribe((x)=>
  {
    console.log(x.userEmail);
    console.log("hii");
        alert('successfully registered')
        this.routes.navigate(['/accounts/login'])
         },error=>{
           alert("This User Email is Already existed");
        })
}

}

export function validateEmail(control:AbstractControl){
  let email=control.value
  console.log(email);
    
  let validRegex ="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$";
  if (email.match(validRegex))
  {
    return null;    
  }
  else
  {
    return {myerr:false}
  }
}

export function validatePass(control:AbstractControl){
  let pass:string=control.value  
  SpotifyChkPassServiceService.prototype.password=pass;
  if(pass.length >=6)
  {
    return null;
  }
  else
  {
    return {myError:false}
  }
}


export function validateconfPass(control:AbstractControl){
  const confpass=control.value
  console.log(confpass);
  const pass= SpotifyChkPassServiceService.prototype.getpasswd()
  console.log(pass);
  
  if(confpass === pass)
  {
  return null
  }
  else{
    return {mayErr1:false}
  }
}

