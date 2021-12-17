package com.techgeeknext.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length=50)
    private String fname;
    @Column(length=50)
    private String lname;
    @Column(length=250)
    private String address;
    @Column(length=7)
    private String pincode;
    @Column(length=50)
    private String state;
    @Column(length=11)
    private String phone;
    
}

