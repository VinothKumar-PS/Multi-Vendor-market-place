package com.example.MultiVendor.entity;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;
}