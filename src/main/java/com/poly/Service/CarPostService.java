package com.poly.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.CarDao;
import com.poly.dao.PendingCarPostDao;
import com.poly.entity.Car;
import com.poly.entity.PendingCarPost;

@Service
public class CarPostService {

    @Autowired
    private PendingCarPostDao pendingCarPostDao;

    @Autowired
    private CarDao carDao;
    
    @Autowired
    private PendingCarPostDao penDao;

    public void addPost(PendingCarPost pendingCarPost) {
        pendingCarPostDao.save(pendingCarPost);
    }

    public List<PendingCarPost> getAllPendingPosts() {
        return pendingCarPostDao.findAll();
    }

    public void approvePost(int postID) {
        PendingCarPost pendingPost = pendingCarPostDao.findById(postID).orElse(null);
        if (pendingPost != null) {
            Car car = new Car();
            car.setCarName(pendingPost.getCarName());
            car.setCarBrand(pendingPost.getCarBrand());
            car.setColor(pendingPost.getColor());
            car.setAddress(pendingPost.getAddress());
            car.setImage(pendingPost.getImage());
            car.setPriceHoursCar(pendingPost.getPriceHoursCar());
            car.setStatus(true);
            car.setDiscountID(pendingPost.getDiscountID()); // Set discountID
            carDao.save(car);
            pendingCarPostDao.delete(pendingPost);
        }
    }

    public void rejectPost(int postID) {
        PendingCarPost pendingPost = pendingCarPostDao.findById(postID).orElse(null);
        if (pendingPost != null) {
            pendingCarPostDao.delete(pendingPost);
        }
    }
    public List<PendingCarPost> getAllApprovedPosts() {
        return penDao.findByStatus(true); // Assuming 'status' is a boolean indicating approval
    }
}
