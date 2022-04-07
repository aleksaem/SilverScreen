package com.machkur.movieland.service;

import com.machkur.movieland.entity.Movie;
import com.machkur.movieland.request.SortingRoute;


public interface MovieService {

    Iterable<Movie> fetchMoviesList();

    Movie addMovie(Movie movie);

    Movie editMovie(Long movieId, Movie movie);

    void deleteMovieById(Long movieId);

    Iterable<Movie> fetchThreeRandomMovies();

    Iterable<Movie> fetchMoviesByGenre(Long genreId);

    Movie fetchMovieById(Long movieId);

    Iterable<Movie> sortMoviesByRating();

    Iterable<Movie> sortMoviesByPrice(SortingRoute sortingRoute);
}
