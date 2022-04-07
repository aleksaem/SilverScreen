package com.machkur.movieland.repository;

import com.machkur.movieland.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(nativeQuery = true, value =
            "SELECT movie_id, native_name, russian_name, description, price, rating, year FROM movies m WHERE ? = any (m.genre_id);")
    Iterable<Movie> findAllByGenresId(Long genreId);

    @Query(nativeQuery=true, value="SELECT movie_id, native_name, russian_name, description, price, rating, year  FROM movies ORDER BY random() LIMIT 3")
    Iterable<Movie> fetchThreeRandomMovies();
}
