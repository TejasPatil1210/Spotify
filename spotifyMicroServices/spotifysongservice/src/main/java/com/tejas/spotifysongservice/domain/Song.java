package com.tejas.spotifysongservice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Song {

    private String songId;
    @Id
    private String songName;
    private String songArtistName;
    private String songAlbumName;
    private String songGenre;
    private String songDuration;
    private String songImageUrl;
}
