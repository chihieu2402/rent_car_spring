package com.poly.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.poly.dao.CarBrandDao;
import com.poly.entity.CarBrand;
import java.util.List;
import java.util.Optional;

@Service
public class CarBrandServiceImp implements CarBrandSerivce {

    @Autowired
    private CarBrandDao carBrandDao;

    @Override
    public Optional<CarBrand> findById(int id) {
        return carBrandDao.findById(id);
    }

    @Override
    public List<CarBrand> findAll() {
        return carBrandDao.findAll();
    }
}
