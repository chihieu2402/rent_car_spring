package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

}
