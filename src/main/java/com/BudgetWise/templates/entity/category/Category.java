package com.BudgetWise.templates.entity.category;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;
@Entity
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private UUID id;
    private String name;
}
