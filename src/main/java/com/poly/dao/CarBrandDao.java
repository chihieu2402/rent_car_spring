
package com.poly.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poly.entity.CarBrand;

@Repository
public interface CarBrandDao extends JpaRepository<CarBrand, Integer> {
	CarBrand findByBrandName(String brandName);

	Optional<CarBrand> findById(int id);
}

