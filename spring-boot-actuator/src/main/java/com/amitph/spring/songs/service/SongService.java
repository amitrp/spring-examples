package com.amitph.spring.songs.service;

import com.amitph.spring.songs.data.SongRepository;
import com.amitph.spring.songs.web.SongDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SongService {
    private final SongRepository repository;
    private final SongTransformer transformer;

    public List<SongDto> getAllSongs() {
        return repository.findAll().stream()
                .map(transformer::transform)
                .collect(Collectors.toList());
    }

    public SongDto addNewSong(SongDto dto) {
        return transformer.transform(repository.save(transformer.transform(dto)));
    }
}
