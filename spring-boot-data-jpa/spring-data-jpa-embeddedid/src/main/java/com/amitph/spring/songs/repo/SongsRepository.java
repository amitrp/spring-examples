package com.amitph.spring.songs.repo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongsRepository extends CrudRepository<Song, SongId> {
    List<Song> findByIdNameAndIdArtist(String name, String artist);
}
