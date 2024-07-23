package com.poly.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccountID")
    private int accountID;

    @Column(name="UserName", columnDefinition = "NVARCHAR(255)")
    private String userName;

    @Column(name="Password", columnDefinition = "NVARCHAR(255)")
    private String passWord;

    @OneToOne(mappedBy = "account")
    private Customer customer;
}
