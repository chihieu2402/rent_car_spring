package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Car;


public interface CarDao extends JpaRepository<Car, Integer>{
	
	List<Car> findByCarID(int carID);



}
