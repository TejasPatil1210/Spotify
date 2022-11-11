import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { UserAuthHeaderComponent } from './user-auth-header/user-auth-header.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { SpotifyHomePageComponent } from './spotify-home-page/spotify-home-page.component';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatMenuModule } from '@angular/material/menu';
import { LoginComponentComponent } from './login-component/login-component.component';
import { RegisterComponentComponent } from './register-component/register-component.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import { SpotifyHomePageHeaderComponent } from './spotify-home-page-header/spotify-home-page-header.component';
import { HttpClientModule } from '@angular/common/http';
import { CreatePlaylistComponent } from './create-playlist/create-playlist.component';
import { PlayMusicComponent } from './play-music/play-music.component';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatSliderModule} from '@angular/material/slider';
import { PlayListDetailComponent } from './play-list-detail/play-list-detail.component';
import { DialogBoxComponent } from './dialog-box/dialog-box.component';
import {MatDialogModule} from '@angular/material/dialog';
import { AddSongComponent } from './add-song/add-song.component';
@NgModule({
  declarations: [
    AppComponent,
    UserAuthHeaderComponent,
    SpotifyHomePageComponent,
    LoginComponentComponent,
    RegisterComponentComponent,
    SpotifyHomePageHeaderComponent,
    CreatePlaylistComponent,
    PlayMusicComponent,
    PlayListDetailComponent,
    DialogBoxComponent,
    AddSongComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatGridListModule,
    MatCardModule,
    MatMenuModule,
    MatFormFieldModule,
    FormsModule, 
    ReactiveFormsModule,
    MatInputModule,
    HttpClientModule,
    MatProgressBarModule,
    MatSliderModule,
    MatDialogModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
