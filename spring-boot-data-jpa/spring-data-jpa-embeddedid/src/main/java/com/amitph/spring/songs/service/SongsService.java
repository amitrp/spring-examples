package com.amitph.spring.songs.service;

import com.amitph.spring.songs.model.SongDto;
import com.amitph.spring.songs.repo.LongKeySong;
import com.amitph.spring.songs.repo.LongKeySongId;
import com.amitph.spring.songs.repo.LongKeySongRepository;
import com.amitph.spring.songs.repo.Song;
import com.amitph.spring.songs.repo.SongId;
import com.amitph.spring.songs.repo.SongsRepository;
import com.amitph.spring.songs.web.SongNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SongsService {
    @Autowired SongsRepository repository;
    @Autowired LongKeySongRepository longKeySongRepository;

    public Song addSong(SongDto dto) {
        return repository.save(dtoToSong(dto));
    }

    public Song find(SongDto dto) {
        return repository.findById(dtoToSongId(dto)).orElseThrow(SongNotFoundException::new);
    }

    private Song dtoToSong(SongDto dto) {
        return new Song(dtoToSongId(dto), dto.getDuration(), dto.getGenre(), dto.getReleaseDate(), dto.getRating(), dto.getDownloadUrl());
    }

    private SongId dtoToSongId(SongDto dto) {
        return new SongId(dto.getName(), dto.getAlbum(), dto.getArtist());
    }


    public List<LongKeySong> findByIdPartially(String name, String artist, String album, String coArtist, String composer, String soundEngineer, String producer, String recordingArtist) {
        return longKeySongRepository.findByIdNameAndIdArtistAndIdAlbumAndIdCoArtistAndIdComposerAndIdSoundEngineerAndIdProducerAndIdRecordingArtist(name, artist, album, coArtist, composer, soundEngineer, producer, recordingArtist);
    }

    public List<LongKeySong> findByIdPartiallyWithExample(String name, String artist, String album, String coArtist, String composer, String soundEngineer, String producer, String recordingArtist) {
        LongKeySong longKeySong = new LongKeySong();
        LongKeySongId longKeySongId = new LongKeySongId();
        longKeySong.setId(longKeySongId);

        longKeySongId.setName(name);
        longKeySongId.setAlbum(album);
        longKeySongId.setArtist(artist);
        longKeySongId.setCoArtist(coArtist);
        longKeySongId.setComposer(composer);
        longKeySongId.setSoundEngineer(soundEngineer);
        longKeySongId.setProducer(producer);
        longKeySongId.setRecordingArtist(recordingArtist);

        Example<LongKeySong> songExample = Example.of(longKeySong);
        return longKeySongRepository.findAll(songExample);
    }

}