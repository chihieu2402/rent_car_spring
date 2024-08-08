package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.CarOwner;

public interface CarOwnerDao extends JpaRepository<CarOwner, Integer> {
//	CarOwner findByOwnerID(int ownerID);
}
