package com.machkur.movieland.service.implementation;

import com.machkur.movieland.entity.Genre;
import com.machkur.movieland.entity.Movie;
import com.machkur.movieland.request.SortingRoute;
import com.machkur.movieland.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

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
                .year(2022)
                .rating(7.83)
                .price(10)
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
                .year(2022)
                .rating(7.83)
                .price(10)
                .build();

        Movie movie2 = Movie.builder()
                .id(2L)
                .russianName("Четверг")
                .nativeName("Thursday")
                .year(2022)
                .rating(7.83)
                .price(10)
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
                .year(2022)
                .rating(7.83)
                .price(10)
                .build();

        movieService.editMovie(3L, movie);

        verify(movieRepository, times(1)).save(movie);
        verify(movieRepository, atLeast(1)).save(any(Movie.class));
    }

    @Test
    @DisplayName("Test deleting movie from database")
    public void testDeleteMovieById(){
        movieService.deleteMovieById(1L);

        verify(movieRepository, times(1)).deleteById(1L);
    }

    @Test
    @DisplayName("Test fetching movies by genre")
    public void testFetchMoviesByGenre(){
        Genre genre = Genre.builder()
                .id(1L)
                .name("Детектив")
                .build();

        Movie movie1 = Movie.builder()
                .id(1L)
                .nativeName("Film 1")
                .genreId(Set.of(genre.getId()))
                .build();
        Movie movie2 = Movie.builder()
                .id(2L)
                .nativeName("Film 2")
                .genreId(Set.of(genre.getId()))
                .build();
        List<Movie> movieList = List.of(movie1, movie2);
        when(movieRepository.findAllByGenresId(1L)).thenReturn(movieList);

        List<Movie> movies = (List<Movie>) movieService.fetchMoviesByGenre(genre.getId());
        assertNotNull(movies);
        assertEquals(2, movies.size());
        assertEquals(movieList, movies);
    }

    @Test
    @DisplayName("Test sorting movies by price ASC")
    public void testSortMoviesByPriceASC(){
        Movie movie1 = Movie.builder()
                .id(1L)
                .nativeName("Film 1")
                .price(10)
                .build();
        Movie movie2 = Movie.builder()
                .id(2L)
                .nativeName("Film 2")
                .price(7)
                .build();
        List<Movie> movies = List.of(movie2, movie1);
        when(movieRepository.findAll(Sort.by(Sort.Direction.ASC, "price"))).thenReturn(movies);

        List<Movie> sortedMovies = (List<Movie>) movieService.sortMoviesByPrice(SortingRoute.ASC);
        assertNotNull(sortedMovies);
        assertEquals(movies, sortedMovies);
        assertTrue(sortedMovies.get(0).getPrice() < sortedMovies.get(1).getPrice());
        verify(movieRepository, times(1)).findAll(Sort.by(Sort.Direction.ASC, "price"));
    }

    @Test
    @DisplayName("Test sorting movies by price DESC")
    public void testSortMoviesByPriceDESC(){
        Movie movie1 = Movie.builder()
                .id(1L)
                .nativeName("Film 1")
                .price(10)
                .build();
        Movie movie2 = Movie.builder()
                .id(2L)
                .nativeName("Film 2")
                .price(7)
                .build();
        List<Movie> movies = List.of(movie1, movie2);
        when(movieRepository.findAll(Sort.by(Sort.Direction.DESC, "price"))).thenReturn(movies);

        List<Movie> sortedMovies = (List<Movie>) movieService.sortMoviesByPrice(SortingRoute.DESC);
        assertNotNull(sortedMovies);
        assertEquals(movies, sortedMovies);
        assertTrue(sortedMovies.get(0).getPrice() > sortedMovies.get(1).getPrice());
        verify(movieRepository, times(1)).findAll(Sort.by(Sort.Direction.DESC, "price"));
    }

    @Test
    @DisplayName("Test sorting movies by rating DESC")
    public void testSortMoviesByRatingDESC(){
        Movie movie1 = Movie.builder()
                .id(1L)
                .nativeName("Film 1")
                .rating(9.99)
                .build();
        Movie movie2 = Movie.builder()
                .id(2L)
                .nativeName("Film 2")
                .rating(7.65)
                .build();
        List<Movie> movies = List.of(movie1, movie2);
        when(movieRepository.findAll(Sort.by(Sort.Direction.DESC, "rating"))).thenReturn(movies);

        List<Movie> sortedMovies = (List<Movie>) movieService.sortMoviesByRating();
        assertNotNull(sortedMovies);
        assertEquals(movies, sortedMovies);
        assertTrue(sortedMovies.get(0).getRating() > sortedMovies.get(1).getRating());
        verify(movieRepository, times(1)).findAll(Sort.by(Sort.Direction.DESC, "rating"));
    }

}