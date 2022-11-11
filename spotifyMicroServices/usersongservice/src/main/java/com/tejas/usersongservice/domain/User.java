package com.tejas.usersongservice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Document
public class User {
    @Id
    private String userEmail;
    private String password;
    private long phoneNumber;
    private List<Playlist> playlists;
}
