package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.entity.Review;
import java.util.List;


public interface ReviewDao extends JpaRepository<Review, Integer> {


	List<Review> findByCarID(int carID);

	  
	  @Query("SELECT AVG(r.rating) FROM Review r WHERE r.carID = :carID")
	    Double findAverageRatingByCarId(@Param("carID") int carID);





}
