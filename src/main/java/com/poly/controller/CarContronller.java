package com.poly.controller;

import java.util.List;

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

import com.poly.Service.FileManagerService;
import com.poly.dao.CarDao;
import com.poly.entity.Car;
//<<<<<<< HEAD

import jakarta.servlet.ServletContext;

import com.poly.Service.FileManagerService;
//=======
//>>>>>>> 4fbecff2ca1f5d594ee90accbcbec4ba70048533

@RequestMapping(value = "/admin")
@Controller
public class CarContronller {

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

    @PostMapping("/car/create")
    public String createCar(@ModelAttribute("car") Car car, 
                            @RequestParam("image") MultipartFile imageFile) {
        if (!imageFile.isEmpty()) {
            // Logic to save the image and set the image path in the Car entity
            String imagePath = fileManagerService.saveFile(imageFile); // Implement this in your service
            car.setImage(imagePath);
        }
        carDao.save(car); // Save the car to the database
        return "redirect:/admin/car"; // Redirect to the car list page or another appropriate page
    }


    @PostMapping("/car/update")
    public String updateCar(@ModelAttribute Car car, @RequestParam("image") MultipartFile file) {
        if (!file.isEmpty()) {
            String savedImageName = fileManagerService.save(file, "cars");
            car.setImage(savedImageName); // Set the saved filename to the car's image field
        }
        carDao.save(car); // Save the updated car to the database
        return "redirect:/admin/car"; // Redirect to the car management page
    }



    @PostMapping("/car/delete/{id}")
    public String deleteCar(@PathVariable int id) {
        Car car = carDao.findById(id).orElse(null);
        if (car != null) {
            fileManagerService.delete("cars", car.getImage()); // Delete the image file
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
