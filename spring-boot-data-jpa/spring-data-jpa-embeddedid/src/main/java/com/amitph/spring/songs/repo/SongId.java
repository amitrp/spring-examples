package com.amitph.spring.songs.repo;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SongId implements Serializable {
    private String name;
    private String album;
    private String artist;

    public SongId(String name, String album, String artist) {
        this.name = name;
        this.album = album;
        this.artist = artist;
    }

    public SongId() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}