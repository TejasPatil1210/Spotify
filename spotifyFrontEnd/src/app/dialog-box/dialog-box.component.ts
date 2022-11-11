import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GetUserSongDataService } from '../services/get-user-song-data.service';
import { KeepLoginUserDetailsService } from '../services/keep-login-user-details.service';

@Component({
  selector: 'app-dialog-box',
  templateUrl: './dialog-box.component.html',
  styleUrls: ['./dialog-box.component.css']
})
export class DialogBoxComponent implements OnInit {

  userData:any 
  dialogForm:FormGroup
  constructor(private route:Router,private getUserServ:GetUserSongDataService,private userser:KeepLoginUserDetailsService) { 
    this.dialogForm=new FormGroup({
      playListName:new FormControl('',[Validators.required])
    })
  }
  
  getUserLogInDet()
  {
    this.userData=this.userser.getUserLoginDetails();   
  }
  ngOnInit(): void {
    this.getUserLogInDet();
  }

  createPlayList()
  {
    console.log(this.userData.userEmail)
      this.getUserServ.createPlayList(this.userData.userEmail,this.dialogForm.value).subscribe(data=>{
        console.log(data);
        this.route.navigate(['/home/addsong/'+data.playListName])  
      },
      (error)=>
      {
        alert(error)
      })
      // this.route.navigate(['/home/addsong/'+this.dialogForm.value])
  }
}
