package io.javabrains.moviecatalogservice.models;

import java.util.ArrayList;


public class MovieWithRating {
		ArrayList<Movie> Movie_Details;
		ArrayList<UserRating> User_Ratings;
		public MovieWithRating(ArrayList<Movie> Movie_Details, ArrayList<UserRating> User_Ratings) {
			super();
			this.Movie_Details= Movie_Details;
			this.User_Ratings = User_Ratings;
		}
		public MovieWithRating() {
			super();
		}
		public ArrayList<Movie> getMovie_Details() {
			return Movie_Details;
		}
		public void setMovie_Details(ArrayList<Movie> movie_Details) {
			Movie_Details = movie_Details;
		}
		public ArrayList<UserRating> getUser_Ratings() {
			return User_Ratings;
		}
		public void setUser_Ratings(ArrayList<UserRating> user_Ratings) {
			User_Ratings = user_Ratings;
		}
		
		
		
}
