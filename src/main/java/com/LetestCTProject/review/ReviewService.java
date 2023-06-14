package com.LetestCTProject.review;

import com.commercetools.api.models.product.ProductResourceIdentifier;
import com.commercetools.api.models.review.Review;
import com.commercetools.api.models.review.ReviewDraft;
import com.commercetools.api.models.state.StateResourceIdentifier;
import com.commercetools.api.models.type.CustomFieldsDraft;
import com.commercetools.api.models.type.FieldContainer;
import com.commercetools.api.models.type.TypeResourceIdentifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    public Review createReview(){
        ReviewDraft reviewDraft = ReviewDraft
                .builder()
                .key("sss")
                .authorName("shubhamGoutam")
                .title("Mr")
                .rating(3)
                .target(ProductResourceIdentifier.builder().id("7d4085c0-37b3-4673-b3e4-2a4f422f90d9").build())
                .custom(CustomFieldsDraft.builder()
                        .type(TypeResourceIdentifier.builder()
                                .key("a333").build())
                        .fields(FieldContainer.builder().addValue("image","https://i.ytimg.com/vi/dgk6j0MmKxI/maxresdefault.jpg").build()).build())
                .build();
        return reviewRepository.createReview(reviewDraft);
    }

}
