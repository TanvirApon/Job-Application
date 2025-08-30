package com.example.jobapp.review.impl;

import com.example.jobapp.company.Company;
import com.example.jobapp.company.CompanyService;
import com.example.jobapp.review.Review;
import com.example.jobapp.review.ReviewRepository;
import com.example.jobapp.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReviewServiceImplement implements ReviewService {
   private final ReviewRepository reviewRepository;
   private final CompanyService companyService;


   public ReviewServiceImplement(ReviewRepository reviewRepository, CompanyService companyService) {
       this.reviewRepository = reviewRepository;
       this.companyService = companyService;
   }
    @Override
    public List<Review> findByCompanyId(Long companyId) {
        List<Review> companyList = reviewRepository.findByCompanyId((companyId));
        return companyList;
    }

    @Override
    public boolean createReview(Long companyId, Review review) {
       Company company = companyService.findCompanyById(companyId);
       if(company!=null){
           review.setCompany(company);
           reviewRepository.save(review);
           return  true;
       }
       else return false;
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId((companyId));
        return reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review review) {
        if(companyService.findCompanyById(companyId) != null){
            review.setCompany(companyService.findCompanyById(companyId));
            review.setId(reviewId);
            reviewRepository.save(review);
            return  true;
        }
        else return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if(companyService.findCompanyById(companyId) != null && reviewRepository.existsById(reviewId)){

            Review review = reviewRepository.findById(reviewId).orElse(null);
            Company company = review.getCompany();
            company.getReview().remove(review);
            companyService.updateCompany(company, companyId);
            reviewRepository.deleteById(reviewId);
            return  true;
        }
        else return false;
    }

}
