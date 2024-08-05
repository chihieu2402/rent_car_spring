package com.poly.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Car")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CarID")
    private int carID;

    @Column(name="CarName", columnDefinition = "NVARCHAR(255)")
    private String carName;
    
    @Column(name="CarBrand")
    private String carBrand;
    
    @Column(name="Color")
    private String color;

    @Column(name="address", columnDefinition = "NVARCHAR(255)")
    private String address;
    
    @Column(name = "Image")
    private String image;

    @Column(name="PriceHoursCar")
    private double priceHoursCar;

    @Column(name="Status")
    private boolean status;
    
    @Column(name = "DiscountID")
    private int discountID;
  
   @ManyToOne
   @JoinColumn(name="ReviewID")
   private Review review;
   
   @OneToMany(mappedBy = "car")
   private List<BillDetail> billDetail;

   @ManyToOne
   @JoinColumn(name="OwnerID")
   private CarOwner carOwner;
   
   @OneToOne
   @JoinColumn(name = "DiscountID", insertable = false, updatable = false)
   private Discount discount;

public Car get(int i) {
	// TODO Auto-generated method stub
	return null;
}




   
}
