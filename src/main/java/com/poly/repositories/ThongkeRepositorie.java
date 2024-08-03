//package com.poly.repositories;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//import com.poly.entity.Bill;
//@Repository
//public interface ThongkeRepositorie extends CrudRepository<Bill, Integer> {
//
//    @Query("SELECT FUNCTION('MONTH', b.rentalDay) as month, SUM(b.totalPrice) as income FROM Bill b GROUP BY FUNCTION('MONTH', b.rentalDay)")
//    List<Object[]> findMonthlyRentalIncome();
//}