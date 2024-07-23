package com.poly.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="BillDetail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BillDetailID")
    private int billDetailID;

    @Column(name="CarID")
    private int carID;

    @Column(name="PhoneNumber")
    private String phoneNumber;

    @Column(name="Address", columnDefinition = "NVARCHAR(255)")
    private String address;

    @Column(name="PriceHoursBillDetail")
    private double priceHoursBillDetail;
    
    @Column(name="RentalHour")
    private double rentalHour;

    @ManyToOne
    @JoinColumn(name = "BillID")
    private Bill bill;
    
    @ManyToOne
    @JoinColumn(name="CarID", insertable = false, updatable = false)
    private Car car;
   
}
