import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Song } from '../modelClasses/Song';
import { PlaymusicService } from '../services/playmusic.service';

@Component({
  selector: 'app-play-music',
  templateUrl: './play-music.component.html',
  styleUrls: ['./play-music.component.css']
})
export class PlayMusicComponent implements OnInit {

  

  songObservable: Observable<any> = new Observable<any>();

  constructor(private activatedRoute: ActivatedRoute, private songserv: PlaymusicService) 
   { 
    
  //   this.songObservable=this.songserv.getData()

     this.activatedRoute.params.subscribe(data => {
      console.log(data['songName']);
       let songName = data['songName'] ;
       this.songObservable = songserv.getData(songName);
     })
  }

  ngOnInit(): void {
  }

}
