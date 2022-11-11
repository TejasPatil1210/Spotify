import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddSongComponent } from './add-song/add-song.component';
import { CreatePlaylistComponent } from './create-playlist/create-playlist.component';
import { AuthGuardGuard } from './guards/auth-guard.guard';
import { LoginComponentComponent } from './login-component/login-component.component';
import { PlayListDetailComponent } from './play-list-detail/play-list-detail.component';
import { PlayMusicComponent } from './play-music/play-music.component';
import { RegisterComponentComponent } from './register-component/register-component.component';
import { SpotifyHomePageHeaderComponent } from './spotify-home-page-header/spotify-home-page-header.component';
import { SpotifyHomePageComponent } from './spotify-home-page/spotify-home-page.component';
import { UserAuthHeaderComponent } from './user-auth-header/user-auth-header.component';

const routes: Routes = [
  {
    path:"home",
    component:SpotifyHomePageHeaderComponent,
    children:[
      {
        path:"",
        component:SpotifyHomePageComponent,
      },
      {  
        path:"playmusic/:songName",
        component:PlayMusicComponent,
         canActivate:[AuthGuardGuard],
      },
      {
        path:"playlist",
        component:CreatePlaylistComponent,
         canActivate:[AuthGuardGuard],
        // children:
        // [
        //   {
        //     path:"playlistdetail/:Song",
        //     component:PlayListDetailComponent,
        //   }
        // ] 
      },
      {
        path:"playlist/playlistdetail/:playListName",
        component:PlayListDetailComponent,
        //  data:{playlistDetail:CreatePlaylistComponent.prototype.userSongData}
      },
      {
        path:"addsong/:playlistName",
        component:AddSongComponent,
      },
      {  
        path:"playlist/playlistdetail/:playListName/playmusic/:songName",
        component:PlayMusicComponent,
        // canActivate:[AuthGuardGuard],
      }
    ]
  },
  {
    path:"accounts",
    component:UserAuthHeaderComponent,
    children:[
      {
        path:"login",
        component:LoginComponentComponent
      },
      {
        path:"register",
        component:RegisterComponentComponent
      },
    ]
  },
  
  {
    path:"",
    redirectTo:"home",
    pathMatch:'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
