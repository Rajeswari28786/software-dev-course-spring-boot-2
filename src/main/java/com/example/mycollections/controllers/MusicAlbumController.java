package com.example.mycollections.controllers;

import com.example.mycollections.models.MusicAlbum;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/MusicAlbums")
public class MusicAlbumController {

    private final List<MusicAlbum> MusicAlbums = new ArrayList<>() {{
        add(new MusicAlbum("Thriller", "Michael Jackson", 1925, 180));
        add(new MusicAlbum("25", "Adele", 1960, 281));
        add(new MusicAlbum("Divide", "Ed Sheeran", 1949, 328));
    }};


    @GetMapping("/json")
    public List<MusicAlbum> getMusicAlbumsJson() {
        return MusicAlbums;
    }

    @GetMapping("/html")
    public String getMusicAlbumsHtml() {
        String MusicAlbumList = "<ul>";
        for (MusicAlbum MusicAlbum : MusicAlbums) {
            MusicAlbumList += "<li>" + MusicAlbum + "</li>";
        }
        MusicAlbumList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>MusicAlbums</h1>
                        <ul>
                """ +
                MusicAlbumList +
                """
                        </ul>
                    </body>
                """;
    }

}