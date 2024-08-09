package com.poly.entity;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "Booking")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BookingID")
    private int bookingID;

    @Column(name = "CarID")
    private int carID;

    @Column(name = "CustomerName")
    private String customerName;

    @Column(name = "RentalDay")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentalDay;

    @Column(name = "ReturnDay")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDay;
    
    @Column(name = "TotalPrice")
    private Double totalPrice;
    
    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "Address")
    private String address;

    @Column(name = "Status")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "CarID", insertable = false, updatable = false)
    private Car car;
}
