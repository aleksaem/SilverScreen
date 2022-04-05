package com.machkur.movieland.repository;

import com.machkur.movieland.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Iterable<Movie> findAllByGenresId(Long genreId);

    long count();
}
