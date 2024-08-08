package com.poly.entity;

import java.sql.Date;
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

    @Column(name = "CustomerName",columnDefinition = "NVARCHAR(255)")
    private String customerName;

    @Column(name = "RentalDay")
    private Date rentalDay; // Removed @Temporal annotation as it's not needed for java.sql.Date

    @Column(name = "ReturnDay")
    private Date returnDay; // Removed @Temporal annotation as it's not needed for java.sql.Date

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "Address",columnDefinition = "NVARCHAR(255)")
    private String address;

    @Column(name = "Status")
    private Boolean status; // To track approval status (true if approved, false otherwise)
}
