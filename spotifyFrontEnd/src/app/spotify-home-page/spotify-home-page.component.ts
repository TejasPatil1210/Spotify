import { Component, OnInit } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { SpotifySongService } from '../services/spotify-song.service';
import { Song } from '../modelClasses/Song';

@Component({
  selector: 'app-spotify-home-page',
  templateUrl: './spotify-home-page.component.html',
  styleUrls: ['./spotify-home-page.component.css']
})
export class SpotifyHomePageComponent implements OnInit{
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
  //       { title: 'Card 1', cols: 1, rows: 1 },
  //       { title: 'Card 2', cols: 1, rows: 1 },
  //       { title: 'Card 3', cols: 1, rows: 1 },
  //       { title: 'Card 4', cols: 1, rows: 1 }
  //     ];
  //   })
  // );

  cards:Observable<Array<any>>
  constructor(private breakpointObserver: BreakpointObserver,private songserv:SpotifySongService) {
    this.cards=this.songserv.getSongData()
  }

  ngOnInit(): void {
  // this.getSong()
  }
  
//   getSong()
//   {
//     {
//       this.songserv.getSongData().subscribe((x)=>
//       {
//         console.log(x);
//         this.cards=x;
//       })  
//     }
// }
}