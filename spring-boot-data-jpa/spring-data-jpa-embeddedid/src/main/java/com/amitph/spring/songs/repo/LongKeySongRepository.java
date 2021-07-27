package com.amitph.spring.songs.repo;

import org.springframework.data.domain.Example;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LongKeySongRepository extends CrudRepository<LongKeySong, LongKeySongId> {
    List<LongKeySong> findAll(Example<LongKeySong> song);

    // Method filters by 8 out of 9 Id keys
    List<LongKeySong> findByIdNameAndIdArtistAndIdAlbumAndIdCoArtistAndIdComposerAndIdSoundEngineerAndIdProducerAndIdRecordingArtist(String name, String artist, String album, String coArtist, String composer, String soundEngineer, String producer, String recordingArtist);
}