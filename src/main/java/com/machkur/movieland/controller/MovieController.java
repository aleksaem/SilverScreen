package com.machkur.movieland.controller;

import com.machkur.movieland.entity.Movie;
import com.machkur.movieland.request.Request;
import com.machkur.movieland.request.SortingRoute;
import com.machkur.movieland.request.SortBy;
import com.machkur.movieland.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/v1/movie")
@Slf4j
@RestController
public class MovieController {

    private MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        log.info("Saving movie: {}", movie);
        return movieService.addMovie(movie);
    }

    @GetMapping
    public Iterable<Movie> fetchMoviesList(@Valid @RequestBody(required = false) Request request) {
        if (request.getSortingStrategy().getSortBy().equals(SortBy.PRICE)) {
            return movieService.sortMoviesByPrice(request.getSortingStrategy().getSortingRoute());
        } else if (request.getSortingStrategy().getSortBy().equals(SortBy.RATING)) {
            return movieService.sortMoviesByRating();
        }
        return movieService.fetchMoviesList();
    }

    @GetMapping("/random")
    public Iterable<Movie> fetchThreeRandomMovies() {
        return movieService.fetchThreeRandomMovies();
    }

    @PutMapping("/{id}")
    public Movie editMovie(@PathVariable("id") Long movieId,
                           @RequestBody Movie movie) {
        log.info("Editing movie with id {}", movieId);
        return movieService.editMovie(movieId, movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable("id") Long movieId) {
        log.info("Deleting movie with id {}", movieId);
        movieService.deleteMovieById(movieId);
    }

    @GetMapping("/genre/{genreId}")
    public Iterable<Movie> fetchMoviesList(@PathVariable Long genreId) {
        return movieService.fetchMoviesByGenre(genreId);
    }
}
