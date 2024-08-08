package com.poly.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PendingCarPost")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PendingCarPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PostID")
    private int postID;

    @Column(name = "CarName", columnDefinition = "NVARCHAR(255)")
    private String carName;

    @ManyToOne
    @JoinColumn(name = "CarBrandID", referencedColumnName = "CarBrandID")
    private CarBrand carBrand;

    @Column(name = "Color", columnDefinition = "NVARCHAR(255)")
    private String color;

    @Column(name = "Address", columnDefinition = "NVARCHAR(255)")
    private String address;

    @Column(name = "Image")
    private String image;

    @Column(name = "OwnershipDocument")
    private String ownershipDocument;

    @Column(name = "PriceHoursCar")
    private double priceHoursCar;

    @Column(name = "Status")
    private boolean status;

    
}
