package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Car;


public interface CarDao extends JpaRepository<Car, Integer>{
	Car findBycarID(Integer carID);

}
