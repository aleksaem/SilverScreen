package com.movieland.cinema.controller;

import com.movieland.cinema.domain.Genre;
import com.movieland.cinema.service.GenreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.movieland.cinema.utils.FileReader.readUFromUrl;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/genres")
public class GenreController {

    private final GenreService genreService;
    String fileName = "https://trello.com/1/cards/5c7d3c9c8d6ddf776c2d3dde/attachments/5c7d3c9d8d6ddf776c2d3e09/download/genre.txt";

    @GetMapping("/add")
    public String addGenre() {

        List<String> rows = readUFromUrl(fileName);
        List<Genre> genres = new ArrayList<>();

        for (int i = 0; i < rows.size(); i++) {
            Genre genre = new Genre();
            genre.setGenre(rows.get(i));
            genres.add(genre);
            log.info("user: {}", genre);
            genreService.addGenre(genre);
        }
        return "redirect:/users";
    }

    @GetMapping()
    public Iterable<Genre> getAll(Model model) {

        Iterable<Genre> genres = genreService.getAllGenres();
        model.addAttribute("genre", genres);
        return genres;
    }
}