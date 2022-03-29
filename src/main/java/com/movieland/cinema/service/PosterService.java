package com.movieland.cinema.service;

import com.movieland.cinema.domain.Poster;
import com.movieland.cinema.repository.PosterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PosterService {

    private final PosterRepository posterRepository;

    public Poster addPoster(Poster poster) {
        return posterRepository.save(poster);
    }

    public Iterable<Poster> getAllPosters() {
        return posterRepository.findAll();
    }

}
