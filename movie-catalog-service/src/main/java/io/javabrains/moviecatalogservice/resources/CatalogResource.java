package io.javabrains.moviecatalogservice.resources;

import io.javabrains.moviecatalogservice.models.CatalogItem;
import io.javabrains.moviecatalogservice.models.Movie;
import io.javabrains.moviecatalogservice.models.MovieWithRating;
import io.javabrains.moviecatalogservice.models.UserRating;

import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    WebClient.Builder webClientBuilder;
    
    
    
    
    @RequestMapping("/allMovies")
    public ArrayList<Movie> allMovies()
    {
    //	ArrayList<Movie> res=restTemplate.getForObject("http://movie-info-service/movies/allMovies", List<Movie>)
    	ResponseEntity<Movie[]> response =
    			  restTemplate.getForEntity(
    			  "http://movie-info-service/movies/allMovies",
    			  Movie[].class);
    			Movie[] movies = response.getBody();
    			
    			return new ArrayList<>(Arrays.asList(movies));

    }
    
    @RequestMapping("/movieDetail/{movieId}")
    public ArrayList<Movie> getMovieById(@PathVariable("movieId") String movieId)
    {
    //	ArrayList<Movie> res=restTemplate.getForObject("http://movie-info-service/movies/allMovies", List<Movie>)
    	ResponseEntity<Movie[]> response =
    			  restTemplate.getForEntity(
    			  "http://movie-info-service/movies/movieDetail/"+movieId,
    			  Movie[].class);
    			Movie[] movies = response.getBody();
    			
    			return new ArrayList<>(Arrays.asList(movies));

    }
    
    @RequestMapping("/userRating/user/{userId}")
    public ArrayList<UserRating> getRatingByUserId(@PathVariable("userId") String userId)
    {
    //	ArrayList<Movie> res=restTemplate.getForObject("http://movie-info-service/movies/allMovies", List<Movie>)
    	ResponseEntity<UserRating[]> response =
    			  restTemplate.getForEntity(
    			  "http://ratings-data-service/userRating/user/"+userId,
    			  UserRating[].class);
    			UserRating[] rating = response.getBody();
    			
    			return new ArrayList<>(Arrays.asList(rating));

    }
    
    
    @RequestMapping("/userRating/movies/{movieId}")
    public ArrayList<UserRating> getRatingByMovieId(@PathVariable("movieId") String movieId)
    {
    //	ArrayList<Movie> res=restTemplate.getForObject("http://movie-info-service/movies/allMovies", List<Movie>)
    	ResponseEntity<UserRating[]> response =
    			  restTemplate.getForEntity(
    			  "http://ratings-data-service/userRating/movies/"+movieId,
    			  UserRating[].class);
    			UserRating[] rating = response.getBody();
    			
    			return new ArrayList<>(Arrays.asList(rating));

    }
    
    
    @RequestMapping("/movieDetailWithRatings/{movieId}")
    public MovieWithRating getRatingWithDetail(@PathVariable("movieId") String movieId)
    {
    	ArrayList<Movie> Movie_Details  = getMovieById(movieId);
    	ArrayList<UserRating> User_Ratings = getRatingByMovieId(movieId);
    	
    	MovieWithRating mr=new MovieWithRating(Movie_Details,User_Ratings);
    	return mr;
    	
    	
    }
    
    
    @RequestMapping("/avgMovieRating/{movieId}")
    public double getAverageRating(@PathVariable("movieId") String movieId)
    {
    	ArrayList<UserRating> User_Ratings = getRatingByMovieId(movieId);
    	int sum=0;
    	for(UserRating ur:User_Ratings)
    	{
    		sum+=ur.getRate();
    		
    	}
    	
    	return (double)sum/User_Ratings.size();
    }

//    @RequestMapping("/{userId}")
//    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
//
//        UserRating userRating = restTemplate.getForObject("http://ratings-data-service/ratingsdata/user/" + userId, UserRating.class);
//
//        return userRating.getRatings().stream()
//                .map(rating -> {
//                    Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
//                    return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
//                })
//                .collect(Collectors.toList());
//
//    }
}

/*
Alternative WebClient way
Movie movie = webClientBuilder.build().get().uri("http://localhost:8082/movies/"+ rating.getMovieId())
.retrieve().bodyToMono(Movie.class).block();
*/