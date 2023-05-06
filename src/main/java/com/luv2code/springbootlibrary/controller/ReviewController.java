package com.luv2code.springbootlibrary.controller;

import com.luv2code.springbootlibrary.dao.BookRepository;
import com.luv2code.springbootlibrary.requestmodels.ReviewRequest;
import com.luv2code.springbootlibrary.service.ReviewService;
import com.luv2code.springbootlibrary.utils.ExtractJWT;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("api/reviews")
public class ReviewController {
    private ReviewService reviewService;
    private final BookRepository bookRepository;

    public ReviewController(ReviewService reviewService,
                            BookRepository bookRepository){
        this.reviewService = reviewService;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/secure/user/book")
    public Boolean reviewBookByUser(@RequestHeader(value="Authorization")String token, @RequestParam Long bookId)throws Exception{
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        if(userEmail == null){
            throw new Exception("User Email is Missing");
        }
        return reviewService.userReviewListed(userEmail, bookId);
    }

    @PostMapping("/secure")
    public void postReview(@RequestHeader(value="Authorization")String token, @RequestBody ReviewRequest reviewRequest)throws Exception{
        String userEmail = ExtractJWT.payloadJWTExtraction(token,"\"sub\"");
        if(userEmail == null){
            throw new Exception("User Email is Missing");
        }
        reviewService.postReview(userEmail, reviewRequest);
    }
}
