package io.javabrains.movieinfoservice.resources;

import io.javabrains.movieinfoservice.models.Movie;
import io.javabrains.movieinfoservice.models.MovieRepo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import antlr.collections.List;

@RestController
@RequestMapping("/movies")
public class MovieResource {

   
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private MovieRepo movierepo; 
    
    @RequestMapping("/allMovies")
    @ResponseBody		
    public ArrayList<Movie> allMovies()
    {
    	ArrayList<Movie> al=new ArrayList<>();
    	al =  (ArrayList<Movie>) movierepo.findAll();
    	
    	return al;
    }

    @RequestMapping("/movieDetail/{movieId}")
    public  ArrayList<Movie> getMovieInfo(@PathVariable("movieId") String movieId) {
        //MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" +  apiKey, MovieSummary.class);
        
    	Optional<Movie> movie=movierepo.findById(movieId);
    	ArrayList<Movie> result = new ArrayList<>();
    	
    	movie.ifPresent(result::add);
    	return result;

    }

}
