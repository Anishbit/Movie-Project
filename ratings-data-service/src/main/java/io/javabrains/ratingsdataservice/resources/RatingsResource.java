package io.javabrains.ratingsdataservice.resources;


import io.javabrains.ratingsdataservice.model.UserRating;
import io.javabrains.ratingsdataservice.model.UserRatingRepo;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userRating")
public class RatingsResource {
@Autowired
	UserRatingRepo userRatingRepo;
    @RequestMapping("/movies/{movieId}")
    public ArrayList<UserRating> getMovieRating(@PathVariable("movieId") String movieId) {
        return userRatingRepo.findByMId(movieId);
        
    }

    @RequestMapping("/user/{userId}")
    public ArrayList<UserRating> getUserRatings(@PathVariable("userId") String userId) {
       
    	ArrayList <UserRating> ur=userRatingRepo.findByUId(userId);
        System.out.println(ur.toString());
    	
        return ur;

    }

}
