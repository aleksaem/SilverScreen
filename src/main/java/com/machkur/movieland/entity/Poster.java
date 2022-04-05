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
@Table(name = "poster")
public class Poster {

    @Id
    @SequenceGenerator(name = "poster_sequence",
            sequenceName = "poster_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "poster_sequence")
    private Long id;
    private String link;
    private String movieName;

}
