package com.poly.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Review")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReviewID")
    private int reviewID;

    @Column(name = "CustomerID")
    private int customerID;
    
    @Column(name="Rating")
    private int rating;

    @Column(name="ReviewText", columnDefinition = "NVARCHAR(255)")
    private String reviewText;

    @Temporal(TemporalType.DATE)
    @Column(name="ReviewDate")
    private Date reviewDate;

    @ManyToOne
    @JoinColumn(name = "CustomerID", insertable = false, updatable = false)
    private Customer customer;
    
    @Column(name = "CarID")
    private int carID;

    @OneToMany(mappedBy = "review")
    private List<Car> car;

}
