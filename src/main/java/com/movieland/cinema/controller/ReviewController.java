package com.movieland.cinema.controller;

import com.movieland.cinema.domain.Review;
import com.movieland.cinema.service.ReviewService;
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
@RequestMapping(path = "/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    String fileName = "https://trello.com/1/cards/5c7d3c9c8d6ddf776c2d3dde/attachments/5c7d3c9d8d6ddf776c2d3e0f/download/review.txt";

    @GetMapping("/add")
    public String addReview() {

        List<String> rows = readUFromUrl(fileName);
        List<Review> reviews = new ArrayList<>();
        Review review = new Review();

        for (int i = 0; i < rows.size(); i++) {
            if (i % 3 == 0) {
                review = new Review();
                review.setMovieName(rows.get(i));
            } else if (i % 3 == 1) {
                review.setUserName(rows.get(i));
            } else if (i % 3 == 2) {
                review.setReview(rows.get(i));
                reviews.add(review);
                log.info("user: {}", review);
                reviewService.addReview(review);
            }
        }
        return "redirect:/users";
    }

    @GetMapping()
    public Iterable<Review> getAll(Model model) {

        Iterable<Review> reviews = reviewService.getAllReviews();
        model.addAttribute("users", reviews);
        return reviews;
    }
}
