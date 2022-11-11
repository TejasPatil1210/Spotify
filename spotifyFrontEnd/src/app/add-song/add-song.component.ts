import { Component } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { SpotifySongService } from '../services/spotify-song.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Song } from '../modelClasses/Song';
import { GetUserSongDataService } from '../services/get-user-song-data.service';
import { KeepLoginUserDetailsService } from '../services/keep-login-user-details.service';
import { __values } from 'tslib';

@Component({
  selector: 'app-add-song',
  templateUrl: './add-song.component.html',
  styleUrls: ['./add-song.component.css']
})
export class AddSongComponent {
  /** Based on the screen size, switch from standard to one column per row */
  // cards = this.breakpointObserver.observe(Breakpoints.Handset).pipe(
  //   map(({ matches }) => {
  //     if (matches) {
  //       return [
  //         { title: 'Card 1', cols: 1, rows: 1 },
  //         { title: 'Card 2', cols: 1, rows: 1 },
  //         { title: 'Card 3', cols: 1, rows: 1 },
  //         { title: 'Card 4', cols: 1, rows: 1 }
  //       ];
  //     }

  //     return [
  //       { title: 'Card 1', cols: 2, rows: 1 },
  //       { title: 'Card 2', cols: 1, rows: 1 },
  //       { title: 'Card 3', cols: 1, rows: 2 },
  //       { title: 'Card 4', cols: 1, rows: 1 }
  //     ];
  //   })
  // );

  cards:Observable<Array<any>>
  userEmail:any
  // plName:any
  constructor(private breakpointObserver: BreakpointObserver,private songserv:SpotifySongService,
    private getUserServ:GetUserSongDataService,private activeRoute:ActivatedRoute,private userser:KeepLoginUserDetailsService
    ,private route:Router) {
    this.cards=this.songserv.getSongData()   
    this.activeRoute.params.subscribe(data=>{
      console.log(data)
      let plName=Object.values(data) ;
      console.log( Object.values(plName)[0])
      this.userser.plname=Object.values(plName)[0];
      console.log(this.userser.plname)
      this.userEmail=this.userser.getUserLoginDetails();
    })
  }

  saveEnabled:boolean=false;
  addSong:boolean=false
  songList:any

  add(x:Song)
  {
    //console.log(this.plName)
    console.log(x)
    this.addSong=true
    this.songList=x
    if(this.songList!==null)
    {
      this.saveEnabled=true;
    }
    else
    {
      this.saveEnabled=false;
    }
    let plName=this.userser.getPlName();
    this.getUserServ.addSongsInPlaylist(this.userEmail.userEmail,plName,this.songList).subscribe((data)=>{
      console.log(data);
      
    },(error)=>{
        console.log(error);
    })
  }

  save()
  {
    //let plName=this.userser.getPlName();
    // console.log(plName)
    // console.log(this.songList)
    // console.log(this.songList[0])
    // this.getUserServ.addSongsInPlaylist(this.userEmail.userEmail,plName,this.songList).subscribe((data)=>{
    //   console.log(data);
      this.route.navigate(['/home/'])
    // },(error)=>{
    //     console.log(error);
    // })
  }


  // ngOnInit(): void {

  // }

}
