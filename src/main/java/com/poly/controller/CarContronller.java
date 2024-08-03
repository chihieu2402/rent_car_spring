package com.poly.controller;

import com.poly.dao.CarDao;
import com.poly.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import com.poly.Service.FileManagerService;
import com.poly.dao.CarDao;
import com.poly.entity.Car;

import jakarta.servlet.ServletContext;

import com.poly.Service.FileManagerService;


@Controller
@RequestMapping("/admin")
public class CarContronller {

    private final String UPLOAD_DIR = "src/main/resources/static/images/";

    @Autowired
    private CarDao carDao;


    @Autowired
    private FileManagerService fileManagerService;
    
    
	@Autowired
	ServletContext app;


    @GetMapping("/car")
    public String car(Model model) {
    	 String path = app.getRealPath("/images/"); 
    	    List<Car> cars = carDao.findAll();
    	    model.addAttribute("cars", cars);
    	    model.addAttribute("car", new Car()); // for the form
    	    return "views/admin/Car"; // Main template with dynamic content
    }

    @GetMapping("/car/edit/{id}")
    public String editCar(@PathVariable int id, Model model) {
        Car car = carDao.findById(id).orElse(null);
        List<Car> cars = carDao.findAll();
        model.addAttribute("cars", cars);
        if (car != null) {
            model.addAttribute("car", car);
        }
        return "views/admin/Car"; // Trả về view để chỉnh sửa
    }

    @PostMapping("/car/create")
    public String createCar(@ModelAttribute Car car, @RequestParam("imageFile") MultipartFile imageFile) {
        handleImageUpload(car, imageFile);
        carDao.save(car);
        return "redirect:/admin/car";
    }

    @PostMapping("/car/update")
    public String updateCar(@ModelAttribute Car car, @RequestParam("imageFile") MultipartFile imageFile) {
        // Kiểm tra xem file ảnh có được tải lên hay không
        if (!imageFile.isEmpty()) {
            handleImageUpload(car, imageFile); // Nếu có file mới, xử lý tải lên
        } else {
            // Nếu không có file mới, không thay đổi trường ảnh
            Car existingCar = carDao.findById(car.getCarID()).orElse(null);
            if (existingCar != null) {
                car.setImage(existingCar.getImage()); // Giữ lại ảnh cũ
            }
        }
        carDao.save(car);
        return "redirect:/admin/car";
    }


    @PostMapping("/car/delete")
    public String deleteCar(@RequestParam("carID") int carID) {
        carDao.deleteById(carID);
        return "redirect:/admin/car";
    }

    private void handleImageUpload(Car car, MultipartFile imageFile) {
        if (!imageFile.isEmpty()) {
            try {
                String fileName = imageFile.getOriginalFilename();
                Path uploadPath = Paths.get(UPLOAD_DIR + fileName);
                Files.copy(imageFile.getInputStream(), uploadPath, StandardCopyOption.REPLACE_EXISTING);
                car.setImage("/images/" + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
