package com.example.jobapp.review;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("company/{companyId}")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("reviews")
    public ResponseEntity<List<Review>> findByCompany(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.findByCompanyId(companyId), HttpStatus.OK);
    }

    @PostMapping("reviews")
    public ResponseEntity<String> createReview(@PathVariable Long companyId, @RequestBody Review review){
           boolean reviewSaved = reviewService.createReview(companyId,review);
           if(reviewSaved){
               return new ResponseEntity<>("Review created", HttpStatus.OK);
           }
           else {
               return new ResponseEntity<>("Review not found", HttpStatus.NOT_FOUND);
           }
    }

    @GetMapping("reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId,@PathVariable Long reviewId ){

        return new ResponseEntity<>(reviewService.getReview(companyId,reviewId), HttpStatus.OK);
    }

    @PutMapping("reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,@PathVariable Long reviewId, @RequestBody Review review){

        boolean reviewUpdated = reviewService.updateReview(companyId,reviewId,review);
        if(reviewUpdated){
            return new ResponseEntity<>("Review updated", HttpStatus.OK);
        }
        else  {
            return new ResponseEntity<>("Review not found", HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId,@PathVariable Long reviewId){
        boolean reviewDeleted = reviewService.deleteReview(companyId,reviewId);
        if(reviewDeleted){
            return new ResponseEntity<>("Review deleted", HttpStatus.OK);
        }
        else  {
            return new ResponseEntity<>("Review not found", HttpStatus.NOT_FOUND);
        }
    }


}
