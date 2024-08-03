//package com.poly.Service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.poly.dao.BillDao;
//import com.poly.dao.CarDao;
//import com.poly.dao.CustomerDao;
//import com.poly.dao.ReviewDao;
//
//
//
//@Service
//public class ThongkeService {
//
//    @Autowired
//    private CustomerDao cuDao;
//    
//    @Autowired
//    private CarDao carDao;
//
//    @Autowired
//    private ReviewDao reviewDao;
//
//    @Autowired
//    private BillDao billDao;
//
//    public long getTotalUsers() {
//        return cuDao.countTotalUsers();
//    }
//
//    public long getTotalCars() {
//        return carDao.countTotalCars();
//    }
//
//    public long getTotalReviews() {
//        return reviewDao.countTotalReviews();
//    }
//
//    public List<Object[]> getMonthlyRentalIncome() {
//        return billDao.findMonthlyRentalIncome();
//    }
//}
