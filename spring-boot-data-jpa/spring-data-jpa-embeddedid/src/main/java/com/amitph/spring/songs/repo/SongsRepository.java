package com.amitph.spring.songs.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongsRepository extends CrudRepository<Song, SongId> {
    List<Song> findByIdNameAndIdArtist(String name, String artist);
}