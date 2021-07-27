package com.amitph.spring.songs.repo;

import javax.persistence.Embeddable;

@Embeddable
public class LongKeySongId {
    private String name;
    private String album;
    private String artist;
    private String coArtist;
    private String soundEngineer;
    private String recordingArtist;
    private String composer;
    private String producer;
    private String country;

    public String getCoArtist() { return coArtist; }

    public void setCoArtist(String coArtist) { this.coArtist = coArtist; }

    public String getSoundEngineer() { return soundEngineer; }

    public void setSoundEngineer(String soundEngineer) { this.soundEngineer = soundEngineer; }

    public String getRecordingArtist() { return recordingArtist; }

    public void setRecordingArtist(String recordingArtist) { this.recordingArtist = recordingArtist; }

    public String getComposer() { return composer; }

    public void setComposer(String composer) { this.composer = composer; }

    public String getProducer() { return producer; }

    public void setProducer(String producer) { this.producer = producer; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name;}

    public String getAlbum() { return album;}

    public void setAlbum(String album) { this.album = album;}

    public String getArtist() { return artist;}

    public void setArtist(String artist) { this.artist = artist;}

}