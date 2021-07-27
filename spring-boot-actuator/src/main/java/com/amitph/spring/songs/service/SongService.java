package com.amitph.spring.songs.service;

import com.amitph.spring.songs.data.SongRepository;
import com.amitph.spring.songs.web.SongDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SongService {
    @Autowired SongRepository repository;
    @Autowired SongTransformer transformer;

    public List<SongDto> getAllSongs() {
        return repository.findAll().stream().map(transformer::transform).collect(Collectors.toList());
    }

    public SongDto addNewSong(SongDto dto) {
        return transformer.transform(repository.save(transformer.transform(dto)));
    }
}