package com.techgeeknext.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "login")
@Getter
@Setter
public class CategoryDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(updatable=false)
    private String name;
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "created_at", updatable=false, columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "last_updated", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
    private Date last_updated;
    
    @Column
    private String last_updated_by;
}

