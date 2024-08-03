package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Review;
import java.util.List;


public interface ReviewDao extends JpaRepository<Review, Integer> {


	Review findByCarID(int carID);

}
