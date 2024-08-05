package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.poly.dao.BookingDao;
import com.poly.entity.Booking;

@Controller
public class BookingController {

    @Autowired
    private BookingDao bookingRepository;

    @GetMapping("/booking/views/Booking")
    public String showBookingForm(@RequestParam int carID, Model model) {
        Booking booking = new Booking();
        booking.setCarID(carID);
        model.addAttribute("booking", booking);
        return "views/Booking"; // Trả về view booking form
    }

    @PostMapping("/booking/submit")
    public String submitBooking(@ModelAttribute Booking booking, RedirectAttributes redirectAttributes) {
        booking.setStatus(false); // Set to false initially until approved by admin
        bookingRepository.save(booking);

        // Add the booking object to the redirect attributes
        redirectAttributes.addFlashAttribute("booking", booking);

        // Redirect to the booking post page after submission
        return "redirect:/booking/post"; // Ensure this endpoint matches your BookingPost view
    }

    @GetMapping("/booking/post")
    public String showBookingPost(Model model) {
        List<Booking> bookings = bookingRepository.findAll();
        model.addAttribute("bookings", bookings);
        return "views/BookingPost"; // Ensure this path matches your HTML file location
    }

    @PostMapping("/index/approveBooking")
    public String approveBooking(@RequestParam("bookingID") int bookingID, RedirectAttributes redirectAttributes) {
        Booking booking = bookingRepository.findById(bookingID).orElseThrow(() -> new IllegalArgumentException("Invalid booking ID:" + bookingID));
        booking.setStatus(true); // Approve booking
        bookingRepository.save(booking);

        redirectAttributes.addFlashAttribute("message", "Booking approved successfully!");

        return "redirect:/booking/post";
    }

    @PostMapping("/index/rejectBooking")
    public String rejectBooking(@RequestParam("bookingID") int bookingID, RedirectAttributes redirectAttributes) {
        Booking booking = bookingRepository.findById(bookingID).orElseThrow(() -> new IllegalArgumentException("Invalid booking ID:" + bookingID));
        bookingRepository.delete(booking);

        redirectAttributes.addFlashAttribute("message", "Booking rejected successfully!");

        return "redirect:/booking/post";
    }
}
