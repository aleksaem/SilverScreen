package com.machkur.movieland.service.implementation;

import com.machkur.movieland.entity.Country;
import com.machkur.movieland.entity.Movie;
import com.machkur.movieland.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class DefaultMovieServiceTest {

    private DefaultMovieService movieService;

    private MovieRepository movieRepository;

    @BeforeEach
    void setUp(){
        movieRepository = mock(MovieRepository.class);
        movieService = new DefaultMovieService();
        movieService.setMovieRepository(movieRepository);
    }

    @Test
    @DisplayName("Test adding movie to database")
    void testAddNewMovie(){
        Movie movie = Movie.builder()
                .id(1L)
                .russianName("Четверг")
                .nativeName("Thursday")
                .yearOfRelease(2022)
                .rating(7.83)
                .price(10)
                .countries(new HashSet<>())
                .genres(new HashSet<>())
                .build();

        movieService.addMovie(movie);

        verify(movieRepository, times(1)).save(movie);
        verify(movieRepository, atLeast(1)).save(any(Movie.class));
    }

    @Test
    @DisplayName("Test find all movies in database")
    public void testFindAllMovies(){
        Movie movie1 = Movie.builder()
                .id(1L)
                .russianName("Четверг")
                .nativeName("Thursday")
                .yearOfRelease(2022)
                .rating(7.83)
                .price(10)
                .countries(new HashSet<>())
                .genres(new HashSet<>())
                .build();

        Movie movie2 = Movie.builder()
                .id(2L)
                .russianName("Четверг")
                .nativeName("Thursday")
                .yearOfRelease(2022)
                .rating(7.83)
                .price(10)
                .countries(new HashSet<>())
                .genres(new HashSet<>())
                .build();

        List<Movie> movieList = List.of(movie1, movie2);
        when(movieRepository.findAll()).thenReturn(movieList);

        List<Movie> foundMovies = (List<Movie>) movieService.fetchMoviesList();
        assertNotNull(foundMovies);
        assertEquals(movieList.size(), foundMovies.size());
        assertEquals(2, foundMovies.size());
        assertEquals(movieList, foundMovies);
    }

    @Test
    @DisplayName("Test editing existing movie from database")
    void testEditExistingMovie(){
        Movie movie = Movie.builder()
                .id(1L)
                .russianName("Четверг")
                .nativeName("Thursday")
                .yearOfRelease(2022)
                .rating(7.83)
                .price(10)
                .countries(new HashSet<>())
                .genres(new HashSet<>())
                .build();

        movieService.editMovie(3L, movie);

        verify(movieRepository, times(1)).save(movie);
        verify(movieRepository, atLeast(1)).save(any(Movie.class));
    }
}