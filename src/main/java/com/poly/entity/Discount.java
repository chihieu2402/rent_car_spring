package com.poly.entity;

import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="Discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DiscountID")
    private int discountID;

    @Column(name="PercentDiscount", columnDefinition = "NVARCHAR(255)")
    private String percentDiscount;

    @Temporal(TemporalType.DATE)
    @Column(name="CreateDate")
    private Date createDate;

    @Column(name="EndDate")
    private String endDate;

    @OneToOne(mappedBy = "discount")
    private Car car;
}
