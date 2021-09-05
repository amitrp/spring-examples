package com.amitph.spring.songs.web;

import com.amitph.spring.songs.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/songs")
@RequiredArgsConstructor
public class SongController {
    private final SongService songService;

    @GetMapping
    public List<SongDto> getAll() {
        return songService.getAllSongs();
    }

    @PostMapping
    public SongDto addSong(@RequestBody SongDto dto) {
        return songService.addNewSong(dto);
    }
}