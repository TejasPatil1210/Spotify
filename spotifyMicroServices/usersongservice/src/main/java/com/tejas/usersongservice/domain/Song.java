package com.tejas.usersongservice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Song {
    private String songId;
    private String songName;
    private String songArtistName;
    private String songDuration;
    private String songAlbumName;
    private String songGenre;
    private String songImageUrl;
}

