package com.machkur.movieland.service.implementation;

import com.machkur.movieland.entity.Genre;
import com.machkur.movieland.repository.GenreRepository;
import com.machkur.movieland.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DefaultGenreService implements GenreService {

    private GenreRepository genreRepository;

    @Autowired
    public void setGenreRepository(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    @Cacheable(value = "genreCache")
    public Iterable<Genre> fetchGenreList() {
        return genreRepository.findAll();
    }

}
