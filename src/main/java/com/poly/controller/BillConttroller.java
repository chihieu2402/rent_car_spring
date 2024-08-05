package com.poly.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.dao.BillDao;
import com.poly.entity.Bill;

@RequestMapping(value = "/admin")
@Controller
public class BillConttroller {
    @Autowired
    private BillDao billDao; // Assuming you have a DAO for Bill

    @GetMapping("/Bill")
    public String listBills(Model model) {
        List<Bill> bills = billDao.findAll(); // Fetch all bills
        model.addAttribute("bills", bills); // Add bills to the model
        model.addAttribute("bill", new Bill()); // Initialize a new Bill object for the form
        return "views/admin/Bill"; // Return the correct view for bill management
    }

    @PostMapping("/bill/create")
    public String createBill(@ModelAttribute("bill") Bill bill) {
        // Calculate total price based on rental hours and price per hour
        double rentalHours = calculateRentalHours(bill.getRentalDay(), bill.getReturnDay());
        double pricePerHour = getPricePerHour(); // Retrieve the price per hour
        bill.setTotalPrice(rentalHours * pricePerHour);
        
        billDao.save(bill); // Save the new bill
        return "redirect:/admin/Bill"; // Redirect back to the bill management page
    }

    @PostMapping("/bill/update")
    public String updateBill(@ModelAttribute("bill") Bill bill) {
        // Ensure that the bill exists before updating
        if (billDao.existsById(bill.getBillID())) {
            // Calculate total price based on rental hours and price per hour
            double rentalHours = calculateRentalHours(bill.getRentalDay(), bill.getReturnDay());
            double pricePerHour = getPricePerHour(); // Retrieve the price per hour
            bill.setTotalPrice(rentalHours * pricePerHour);
            
            billDao.save(bill); // Update the existing bill
        }
        return "redirect:/admin/Bill"; // Redirect back to the bill management page
    }

    @PostMapping("/bill/delete/{id}")
    public String deleteBill(@PathVariable("id") int id) {
        billDao.deleteById(id); // Delete the bill by its ID
        return "redirect:/admin/Bill"; // Redirect back to the bill management page
    }

    @GetMapping("/bill/edit/{id}")
    public String editBill(@PathVariable("id") int id, Model model) {
        Bill bill = billDao.findById(id).orElse(new Bill()); // Fetch the bill by its ID or return a new Bill if not found
        model.addAttribute("bill", bill); // Add the bill to the model
        List<Bill> bills = billDao.findAll(); // Fetch all bills
        model.addAttribute("bills", bills); // Add bills to the model
        return "views/admin/Bill"; // Return the correct view for bill management
    }

    private double calculateRentalHours(String rentalDay, String returnDay) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date rentalDate = sdf.parse(rentalDay);
            Date returnDate = sdf.parse(returnDay);
            
            long durationInMillis = returnDate.getTime() - rentalDate.getTime();
            return TimeUnit.MILLISECONDS.toHours(durationInMillis); // Convert to hours
        } catch (ParseException e) {
            e.printStackTrace();
            return 0; // Return 0 if there's an error in parsing
        }
    }

    private double getPricePerHour() {
        // Assuming a fixed price per hour for simplicity, modify as needed
        return 10.0; // Change this to retrieve from your Car entity or other source
    }
}
