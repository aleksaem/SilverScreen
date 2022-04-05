package com.machkur.movieland.service.implementation;

import com.machkur.movieland.entity.Genre;
import com.machkur.movieland.entity.Movie;
import com.machkur.movieland.entity.util.SortingRoute;
import com.machkur.movieland.repository.MovieRepository;
import com.machkur.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.stream.StreamSupport;

@Service
public class DefaultMovieService implements MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie addMovie(Movie movie) {
        movieRepository.save(movie);
        return movie;
    }

    @Override
    public Iterable<Movie> fetchMoviesList() {
        return movieRepository.findAll();
    }

    @Override
    public Movie editMovie(Long movieId, Movie movie) {
        movie.setId(movieId);
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovieById(Long movieId) {
        movieRepository.deleteById(movieId);
    }

    @Override
    public Iterable<Movie> fetchThreeRandomMovies() {
        Long quantity = movieRepository.count();
        int index = (int) (Math.random() * quantity);
        Iterable<Movie> movies = movieRepository.findAll(PageRequest.of(index, 3));
        long movieSize = StreamSupport.stream(movies.spliterator(), false).count();
        if (movieSize > 0) {
            return movies;
        }
        return null;
    }

    @Override
    public Iterable<Movie> fetchMoviesByGenre(Genre genre) {
        return movieRepository.findAllByGenresId(genre.getId());
    }

    @Override
    public Iterable<Movie> sortMoviesByRating(SortingRoute sortingRoute) {
        if (sortingRoute.toString().equals("ASC")) {
            return movieRepository.findAll(Sort.by(Sort.Direction.ASC, "rating"));
        } else {
            return movieRepository.findAll(Sort.by(Sort.Direction.DESC, "rating"));
        }
    }

    @Override
    public Iterable<Movie> sortMoviesByPrice(SortingRoute sortingRoute) {
        if (sortingRoute.toString().equals("ASC")) {
            return movieRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
        } else {
            return movieRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));
        }
    }
}
