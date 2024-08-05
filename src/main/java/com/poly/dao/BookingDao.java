package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Booking;


public interface BookingDao extends JpaRepository<Booking, Integer> {

}
