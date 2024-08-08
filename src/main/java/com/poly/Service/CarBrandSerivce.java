package com.poly.Service;

import java.util.List;
import java.util.Optional;
import com.poly.entity.CarBrand;

public interface CarBrandSerivce {
    Optional<CarBrand> findById(int id);
    List<CarBrand> findAll();
}
