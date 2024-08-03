package com.poly.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PendingCarPost")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PendingCarPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PostID")
    private int postID;

    
    @Column(name = "CarName",columnDefinition = "NVARCHAR(255)")
    private String carName;

    @Column(name = "CarBrand",columnDefinition = "NVARCHAR(255)")
    private String carBrand;

    @Column(name = "Color",columnDefinition = "NVARCHAR(255)")
    private String color;

    @Column(name = "address",columnDefinition = "NVARCHAR(255)")
    private String address;

    @Column(name = "Image")
    private String image;

    @Column(name = "PriceHoursCar")
    private double priceHoursCar;

    @Column(name = "Status")
    private boolean status;

    @Column(name = "CustomerName",columnDefinition = "NVARCHAR(255)")
    private String customerName;

    @Column(name = "DiscountID",columnDefinition = "NVARCHAR(255)")
    private Integer discountID;  

}
