package com.poly.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Date rentalDay; // Removed @Temporal annotation as it's not needed for java.sql.Date

    @Column(name = "ReturnDay")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date returnDay; // Removed @Temporal annotation as it's not needed for java.sql.Date
    
    @Column(name = "TotalPrice")
    private Double totalPrice;
    
    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "Address")
    private String address;

    @Column(name = "Status")
    private Boolean status; // To track approval status (true if approved, false otherwise)
    
    @ManyToOne
    @JoinColumn(name = "CarID",insertable=false, updatable=false)
    private Car car; // To link to the Car entity via CarID. This is a one-to-many relationship.;
}