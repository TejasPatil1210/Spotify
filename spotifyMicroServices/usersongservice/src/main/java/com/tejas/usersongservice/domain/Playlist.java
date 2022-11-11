package com.tejas.usersongservice.domain;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Playlist {
    private String playListName;
    private List<Song> SongsList;
}
