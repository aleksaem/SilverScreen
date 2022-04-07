package com.machkur.movieland.service.implementation;

import com.machkur.movieland.entity.Movie;
import com.machkur.movieland.request.SortingRoute;
import com.machkur.movieland.repository.MovieRepository;
import com.machkur.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Optional<Movie> byId = movieRepository.findById(movieId);
        Movie foundMovie = null;
        if (byId.isPresent()) {
            foundMovie = byId.get();
            if (movie.getNativeName() != null) {
                foundMovie.setNativeName(movie.getNativeName());
            }
            if (movie.getRussianName() != null) {
                foundMovie.setRussianName(movie.getRussianName());
            }
            if (movie.getDescription() != null) {
                foundMovie.setDescription(movie.getDescription());
            }
            if (movie.getYear() != 0) {
                foundMovie.setYear(movie.getYear());
            }
            if (movie.getRating() != 0.0) {
                foundMovie.setRating(movie.getRating());
            }
            if (movie.getPrice() != 0.0) {
                foundMovie.setPrice(movie.getPrice());
            }
        }
        return movieRepository.save(foundMovie);
    }

    @Override
    public void deleteMovieById(Long movieId) {
        movieRepository.deleteById(movieId);
    }

    @Override
    public Iterable<Movie> fetchThreeRandomMovies() {
        return movieRepository.fetchThreeRandomMovies();
    }

    @Override
    public Iterable<Movie> fetchMoviesByGenre(Long genreId) {
        return movieRepository.findAllByGenresId(genreId);
    }

    @Override
    public Movie fetchMovieById(Long movieId) {
        Optional<Movie> foundMovie = movieRepository.findById(movieId);

        if (foundMovie.isPresent()) {
            return foundMovie.get();
        } else {
            throw new IllegalArgumentException("Movie with id " + movieId + " doesn`t exist");
        }
    }

    @Override
    public Iterable<Movie> sortMoviesByRating() {
        return movieRepository.findAll(Sort.by(Sort.Direction.DESC, "rating"));
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
