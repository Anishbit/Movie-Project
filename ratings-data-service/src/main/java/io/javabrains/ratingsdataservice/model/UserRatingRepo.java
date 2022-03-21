package io.javabrains.ratingsdataservice.model;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UserRatingRepo extends CrudRepository<UserRating, String>{

	ArrayList<UserRating> findByUId(String userId);

	ArrayList<UserRating> findByMId(String movieId);

}
