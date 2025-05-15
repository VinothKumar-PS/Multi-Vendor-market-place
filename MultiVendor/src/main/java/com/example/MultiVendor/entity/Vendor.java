package com.example.MultiVendor.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL)
    private List<Product> products;
}
