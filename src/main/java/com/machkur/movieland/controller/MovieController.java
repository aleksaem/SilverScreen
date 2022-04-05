package com.machkur.movieland.controller;

import com.machkur.movieland.entity.Movie;
import com.machkur.movieland.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/movies")
@RestController
public class MovieController {

    private MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService){
        this.movieService = movieService;
    }

    private final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie){
        LOGGER.info("Saving movie: {}", movie);
        return movieService.addMovie(movie);
    }

    @GetMapping
    public Iterable<Movie> fetchMoviesList(){
        return movieService.fetchMoviesList();
    }

    @PutMapping("/{id}")
    public Movie editMovie(@PathVariable("id") Long movieId,
                           @RequestBody Movie movie){
        LOGGER.info("Editing movie with id {}", movieId);
        return movieService.editMovie(movieId, movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable("id") Long movieId){
        LOGGER.info("");
    }

}
