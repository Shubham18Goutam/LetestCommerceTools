package com.LetestCTProject.review;

import com.LetestCTProject.config.Client;
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.review.Review;
import com.commercetools.api.models.review.ReviewDraft;
import org.springframework.stereotype.Component;

@Component
public class ReviewRepository {

    ProjectApiRoot apiRoot = Client.createApiClient();


    public Review createReview(ReviewDraft reviewDraft) {
        return apiRoot.reviews().post(reviewDraft).executeBlocking().getBody();
    }
}
