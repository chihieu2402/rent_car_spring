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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Discount")
@Data
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
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
