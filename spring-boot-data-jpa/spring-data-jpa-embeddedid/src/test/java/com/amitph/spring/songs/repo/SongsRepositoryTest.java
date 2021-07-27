package com.amitph.spring.songs.repo;

import com.amitph.spring.songs.web.SongNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

@DataJpaTest
@RunWith(SpringRunner.class)
public class SongsRepositoryTest {
    @Autowired SongsRepository repository;
    @Autowired TestEntityManager testEntityManager;

    @Test
    public void repoCorrectlySavesGivenSong() {
        SongId songId = new SongId("test_name", "test_album", "test_artist");
        Song song = new Song(songId, 23, null, null, 4, "http://download.this.song");

        repository.save(song);

        Song result = testEntityManager.find(Song.class, songId);
        assertTrue(result.getDownloadUrl().equals(song.getDownloadUrl()));
        assertTrue(result.getId().getAlbum().equals(song.getId().getAlbum()));
        assertTrue(result.getId().getName().equals(song.getId().getName()));
        assertTrue(result.getId().getArtist().equals(song.getId().getArtist()));
    }


    @Test
    public void repoCorrectlyFindsSongById() {
        List<Song> songs = insertFourSongsInDataBase();
        int testSongIndex = 3;

        SongId idToRetrieve = songs.get(testSongIndex).getId();

        Song result = repository.findById(idToRetrieve).orElseThrow(SongNotFoundException::new);

        assertTrue(result.getId().getAlbum().equals(songs.get(testSongIndex).getId().getAlbum()));
        assertTrue(result.getId().getName().equals(songs.get(testSongIndex).getId().getName()));
        assertTrue(result.getId().getArtist().equals(songs.get(testSongIndex).getId().getArtist()));

        assertTrue(result.getDuration() == songs.get(testSongIndex).getDuration());
        assertTrue(result.getRating() == songs.get(testSongIndex).getRating());
        assertTrue(result.getDownloadUrl().equals(songs.get(testSongIndex).getDownloadUrl()));
    }

    private List<Song> insertFourSongsInDataBase() {
        SongId songId1 = new SongId("test_name1", "test_album1", "test_artist1");
        Song song1 = new Song(songId1, 23, null, null, 3, "http://download.this.song1");

        SongId songId2 = new SongId("test_name2", "test_album2", "test_artist2");
        Song song2 = new Song(songId2, 21, null, null, 2, "http://download.this.song2");

        SongId songId3 = new SongId("test_name3", "test_album3", "test_artist3");
        Song song3 = new Song(songId3, 20, null, null, 4, "http://download.this.song3");

        SongId songId4 = new SongId("test_name4", "test_album4", "test_artist4");
        Song song4 = new Song(songId4, 26, null, null, 2, "http://download.this.song4");

        List<Song> songs = new ArrayList<>();
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);

        testEntityManager.persistAndFlush(song1);
        testEntityManager.persistAndFlush(song2);
        testEntityManager.persistAndFlush(song3);
        testEntityManager.persistAndFlush(song4);
        return songs;
    }
}