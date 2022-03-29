package com.movieland.cinema.service;

import com.movieland.cinema.domain.Movie;
import com.movieland.cinema.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Iterable<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
