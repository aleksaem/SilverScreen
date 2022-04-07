package com.machkur.movieland.service.implementation;

import com.machkur.movieland.entity.Genre;
import com.machkur.movieland.entity.Movie;
import com.machkur.movieland.repository.GenreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class DefaultGenreServiceTest{

    private DefaultGenreService genreService;

    private GenreRepository genreRepository;

    @BeforeEach
    void setUp(){
        genreRepository = mock(GenreRepository.class);
        genreService = new DefaultGenreService();
        genreService.setGenreRepository(genreRepository);
    }

    @Test
    @DisplayName("Test find all genres in database")
    public void testFindAllGenres(){
        Genre genre1 = Genre.builder()
                .id(1L)
                .name("Horror")
                .build();

        Genre genre2 = Genre.builder()
                .id(2L)
                .name("Detective")
                .build();

        List<Genre> genreList = List.of(genre1, genre2);
        when(genreRepository.findAll()).thenReturn(genreList);

        List<Genre> foundGenres = (List<Genre>) genreService.fetchGenreList();
        assertNotNull(foundGenres);
        assertEquals(genreList.size(), foundGenres.size());
        assertEquals(2, foundGenres.size());
        assertEquals(genreList, foundGenres);
    }
}