package com.movieland.cinema.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long review_id;

    @Column(name = "review", length = 1024)
    private String review;
    private String userName;
    private String movieName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Review review = (Review) o;
        return review_id != null && Objects.equals(review_id, review.review_id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Review{" +
                "review_id=" + review_id +
                ", review='" + review + '\'' +
                ", userName='" + userName + '\'' +
                ", movieName='" + movieName + '\'' +
                '}';
    }
}
