package com.LetestCTProject.review;

import com.commercetools.api.models.review.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {
    @Autowired
    ReviewService service;

    @PostMapping("/B")
    public Review createReview(){
        return service.createReview();
    }
}
