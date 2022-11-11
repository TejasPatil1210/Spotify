import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { GetUserSongDataService } from '../services/get-user-song-data.service';
import { KeepLoginUserDetailsService } from '../services/keep-login-user-details.service';

@Component({
  selector: 'app-play-list-detail',
  templateUrl: './play-list-detail.component.html',
  styleUrls: ['./play-list-detail.component.css']
})
export class PlayListDetailComponent implements OnInit {
  userDet:any=null
  songs:any
  checkNull:boolean=true;
  constructor(private activeRoute:ActivatedRoute,private userdata:KeepLoginUserDetailsService,private getplData:GetUserSongDataService)
   { 
  
    this.activeRoute.params.subscribe(data=>{
      console.log(data)
      this.userDet=userdata.getUserLoginDetails(); 
       let playListName:any=data['playListName'];
      console.log(playListName)
      try {  
      this.getplData.getPlaylistData(this.userDet.userEmail,playListName).subscribe(data=>{
        console.log(data)        
        this.songs=data;
        if(this.songs.songsList!==null)
        {
          this.checkNull=false;
        }
      });
    } catch (error) {
      console.log(error)   
    }
      console.log(this.songs)
    })
  
  }


  ngOnInit(): void {
  }

}
