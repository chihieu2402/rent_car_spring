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

    @Column(name = "CarName")
    private String carName;

    @Column(name = "CarBrand")
    private String carBrand;

    @Column(name = "Color")
    private String color;

    @Column(name = "address")
    private String address;

    @Column(name = "Image")
    private String image;

    @Column(name = "PriceHoursCar")
    private double priceHoursCar;

    @Column(name = "Status")
    private boolean status;

    @Column(name = "CustomerName")
    private String customerName;
}
