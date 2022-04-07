package com.machkur.movieland.controller;

import com.machkur.movieland.entity.Genre;
import com.machkur.movieland.service.GenreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1/genre")
public class GenreController {

    private GenreService genreService;

    @Autowired
    public void setGenreService(GenreService genreService){
        this.genreService = genreService;
    }

    @GetMapping
    public Iterable<Genre> fetchGenreList(){
        return genreService.fetchGenreList();
    }
}
