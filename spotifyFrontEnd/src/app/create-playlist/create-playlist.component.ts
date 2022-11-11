import { Component, OnInit } from '@angular/core';
import { GetUserSongDataService } from '../services/get-user-song-data.service';
import { KeepLoginUserDetailsService } from '../services/keep-login-user-details.service';

@Component({
  selector: 'app-create-playlist',
  templateUrl: './create-playlist.component.html',
  styleUrls: ['./create-playlist.component.css']
})
export class CreatePlaylistComponent implements OnInit {

  checkNull:boolean=true;
  userData:any 
  userSongData:any
  //count:number=0
  constructor(private userser:KeepLoginUserDetailsService,private userSongServ:GetUserSongDataService) { }

  getUserLogInDet()
  {
    this.userData=this.userser.getUserLoginDetails();   
  }


  getUserSongDet()
  {
    try{
    this.userSongServ.getUserData(this.userData.userEmail).subscribe(x=>{
      console.log(x);
      this.userSongData=x;
      console.log(this.userSongData.playlists)
      if(this.userSongData!==null)
      {
        this.checkNull=false;
        console.log(this.checkNull);
        // console.log(this.userSongData.playlists[0].songsList.length )
        // // for(let i=0;i<this.userSongData.playlists.length ;i++)
        // {
        //  this.count++; 
        // }
      }
    
    })
  }
  catch(Error )
  { 
    console.log(Error)
  }
  }
  ngOnInit(): void {
    this.getUserLogInDet();
    this.getUserSongDet();
    console.log(this.checkNull)
  }

}
