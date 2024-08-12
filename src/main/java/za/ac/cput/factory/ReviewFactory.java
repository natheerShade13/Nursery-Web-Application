package za.ac.cput.factory;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Review;
import za.ac.cput.util.ReviewHelper;

import java.time.LocalDate;

public class ReviewFactory {

    public static Review buildReview(long reviewId, String comment, LocalDate reviewDate,
                                     Customer customer){
        if (ReviewHelper.validId(reviewId) || ReviewHelper.isNullOrEmpty(comment)
                || ReviewHelper.isNull(reviewDate)  || customer == null){
            return null;
        }

        return new Review.Builder().setReviewId(reviewId).setComment(comment).setReviewDate(reviewDate)
                .setCustomer(customer).build();
    }

}
