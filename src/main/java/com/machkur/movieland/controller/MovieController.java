package com.machkur.movieland.controller;

import com.machkur.movieland.dto.FullMovieDto;
import com.machkur.movieland.dto.SimpleMovieDto;
import com.machkur.movieland.entity.Movie;
import com.machkur.movieland.mapper.MovieMapper;
import com.machkur.movieland.mapper.list.MovieListMapper;
import com.machkur.movieland.request.Request;
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
    public SimpleMovieDto addMovie(@RequestBody Movie movie) {
        log.info("Saving movie: {}", movie);
        return MovieMapper.MOVIE_MAPPER.movieToSimpleMovieDto(movieService.addMovie(movie));
    }

    @GetMapping
    public Iterable<SimpleMovieDto> fetchMoviesList(@Valid @RequestBody(required = false) Request request) {
        if (request.getSortingStrategy().getSortBy().equals(SortBy.PRICE)) {
            return MovieListMapper.MOVIE_LIST_MAPPER.movieToSimpleMovieDtos(
                    movieService.sortMoviesByPrice(request.getSortingStrategy().getSortingRoute()));
        } else if (request.getSortingStrategy().getSortBy().equals(SortBy.RATING)) {
            return MovieListMapper.MOVIE_LIST_MAPPER.movieToSimpleMovieDtos(movieService.sortMoviesByRating());
        }
        return MovieListMapper.MOVIE_LIST_MAPPER.movieToSimpleMovieDtos(movieService.fetchMoviesList());
    }

    @GetMapping("/random")
    public Iterable<SimpleMovieDto> fetchThreeRandomMovies() {
        return MovieListMapper.MOVIE_LIST_MAPPER.movieToSimpleMovieDtos(movieService.fetchThreeRandomMovies());
    }

    @PutMapping("/{id}")
    public SimpleMovieDto editMovie(@PathVariable("id") Long movieId,
                                    @RequestBody Movie movie) {
        log.info("Editing movie with id {}", movieId);
        return MovieMapper.MOVIE_MAPPER.movieToSimpleMovieDto(movieService.editMovie(movieId, movie));
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable("id") Long movieId) {
        log.info("Deleting movie with id {}", movieId);
        movieService.deleteMovieById(movieId);
    }

    @GetMapping("/genre/{genreId}")
    public Iterable<SimpleMovieDto> fetchMoviesList(@PathVariable Long genreId) {
        return MovieListMapper.MOVIE_LIST_MAPPER.movieToSimpleMovieDtos(movieService.fetchMoviesByGenre(genreId));
    }

    @GetMapping("/{id}")
    public FullMovieDto fetchMovieById(@PathVariable("id") Long movieId){
        return MovieMapper.MOVIE_MAPPER.movieToFullMovieDto(movieService.fetchMovieById(movieId));
    }
}
