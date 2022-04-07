package com.machkur.movieland.service;

import com.machkur.movieland.entity.Genre;

public interface GenreService {

    Iterable<Genre> fetchGenreList();
}
