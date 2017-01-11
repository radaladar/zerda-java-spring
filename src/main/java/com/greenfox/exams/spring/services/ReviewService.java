/// Created by BB on 2017-01-11.
package com.greenfox.exams.spring.services;

import com.greenfox.exams.spring.domain.Review;
import com.greenfox.exams.spring.domain.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public String validate(Review review) {
        String errors = "";
        if (!checkExperience(review)) {errors += "Review not valid!\n";}
        if (!checkRating(review)) {errors += "Rating not valid!\n";}
        if (!checkEmail(review)) {errors += "Email not valid!\n";}
        return errors;
    }

    public void submit(Review review) {
        reviewRepository.save(review);
    }

    private boolean checkEmail(Review review) {
        return review.getEmail().contains("@") && review.getEmail().contains(".");
    }

    private boolean checkExperience(Review review) {
        String[] acceptableWords= {"amazing", "awesome", "blithesome", "excellent", "fabulous", "fantastic", "favorable", "fortuitous", "great", "incredible", "ineffable", "mirthful", "outstanding", "perfect", "propitious", "remarkable", "smart", "spectacular", "splendid", "stellar", "stupendous", "super", "ultimate", "unbelievable", "wondrous"};
        int counter = 0;
        for (String word : acceptableWords) {
            if (review.getExperience().toLowerCase().contains(word)) {
                counter++;
            }

        }
        return counter >= 3;
    }

    private boolean checkRating(Review review) {
        return review.getRating() >= 10;
    }
}
