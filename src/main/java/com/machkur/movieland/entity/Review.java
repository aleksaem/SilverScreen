package com.machkur.movieland.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "review")
public class Review {

    @Id
    @SequenceGenerator(name = "review_sequence",
            sequenceName = "review_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "review_sequence")
    private Long id;
    private String review;

    @ManyToOne
    @JoinColumn(name = "movie_reviews", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "users_reviews", nullable = false)
    private User user;

}
