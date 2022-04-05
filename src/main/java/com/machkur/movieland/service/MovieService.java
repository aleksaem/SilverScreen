package com.machkur.movieland.service;

import com.machkur.movieland.entity.Genre;
import com.machkur.movieland.entity.Movie;
import com.machkur.movieland.entity.util.SortingRoute;


public interface MovieService {

    Movie addMovie(Movie movie);

    Iterable<Movie> fetchMoviesList();

    Movie editMovie(Long movieId, Movie movie);

    void deleteMovieById(Long movieId);

    Iterable<Movie> fetchThreeRandomMovies();

    Iterable<Movie> fetchMoviesByGenre(Genre genre);

    Iterable<Movie> sortMoviesByRating(SortingRoute sortingRoute);

    Iterable<Movie> sortMoviesByPrice(SortingRoute sortingRoute);
}
