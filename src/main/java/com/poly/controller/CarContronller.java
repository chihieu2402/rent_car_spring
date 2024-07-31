package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poly.dao.CarDao;
import com.poly.entity.Car;
import com.poly.Service.FileManagerService;

@RequestMapping(value = "/admin")
@Controller
public class CarContronller {

    @Autowired
    private CarDao carDao;

    @Autowired
    private FileManagerService fileManagerService;

    @GetMapping("/car")
    public String car(Model model) {
        List<Car> cars = carDao.findAll();
        model.addAttribute("cars", cars);
        model.addAttribute("car", new Car()); // for the form
        return "views/admin/Car"; // Main template with dynamic content
    }

    @PostMapping("/car/create")
    public String createCar(@ModelAttribute Car car, @RequestParam("image") MultipartFile file) {
        if (!file.isEmpty()) {
            List<String> filenames = fileManagerService.save("cars", new MultipartFile[]{file});
            if (!filenames.isEmpty()) {
                car.setImage(filenames.get(0));
            }
        }
        carDao.save(car); // Save the new car to the database
        return "redirect:/admin/car"; // Redirect to the car management page
    }

    @PostMapping("/car/update")
    public String updateCar(@ModelAttribute Car car, @RequestParam("image") MultipartFile file) {
        if (!file.isEmpty()) {
            List<String> filenames = fileManagerService.save("cars", new MultipartFile[]{file});
            if (!filenames.isEmpty()) {
                car.setImage(filenames.get(0));
            }
        }
        carDao.save(car); // Save the updated car to the database
        return "redirect:/admin/car"; // Redirect to the car management page
    }

    @PostMapping("/car/delete/{id}")
    public String deleteCar(@PathVariable int id) {
        Car car = carDao.findById(id).orElse(null);
        if (car != null) {
            fileManagerService.delete("cars", car.getImage());
            carDao.deleteById(id); // Delete the car with the specified ID
        }
        return "redirect:/admin/car"; // Redirect to the car management page
    }

    @GetMapping("/car/edit/{id}")
    public String editCar(@PathVariable int id, Model model) {
        Car car = carDao.findById(id).orElse(new Car());
        model.addAttribute("car", car);
        model.addAttribute("cars", carDao.findAll());
        return "views/admin/Car";
    }
}
