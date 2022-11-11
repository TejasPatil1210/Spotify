import { Component, OnInit } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { KeepLoginUserDetailsService } from '../services/keep-login-user-details.service';
import { CheckAuthUserService } from '../services/check-auth-user.service';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { DialogBoxComponent } from '../dialog-box/dialog-box.component';

@Component({
  selector: 'app-spotify-home-page-header',
  templateUrl: './spotify-home-page-header.component.html',
  styleUrls: ['./spotify-home-page-header.component.css']
})
export class SpotifyHomePageHeaderComponent implements OnInit{

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  checkUserAuth:boolean=this.chkusr.CheckAuthorizeUser();  
  userLogData:any
  constructor(private breakpointObserver: BreakpointObserver,private logincred:KeepLoginUserDetailsService ,private chkusr:CheckAuthUserService,private route:Router,
    public dialog: MatDialog) {}
  ngOnInit()
  {
    this.getUserLogDet();
    this.checkUserAuth;
  }


  opendialog()
  {
    const dialogRef = this.dialog.open(DialogBoxComponent)
    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
      // this.getuserData();
    });
  }

  signUp()
  {
    this.route.navigate(['accounts/register'])
  }

  logIn()
  {
    this.route.navigate(['accounts/login'])
  }

  getUserLogDet()
  {
    this.userLogData=this.logincred.getUserLoginDetails();
    console.log(this.userLogData);
    console.log(this.logincred.getUserLoginDetails())
  }

  userLogOut()
  {
    this.chkusr.authorizeUser=false;
    this.route.navigate(['']).then(()=>{
      window.location.reload();
    });
    
  }
}
