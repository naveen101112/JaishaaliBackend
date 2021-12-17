package com.techgeeknext.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "login")
@Getter
@Setter
public class SubCategoryDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column
    private int categoryId;
    
    @Column
    private String name;
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "created_at", updatable=false, columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    
    @Column
    private String price;
    
    @Column
    private String last_updated_by;
}

