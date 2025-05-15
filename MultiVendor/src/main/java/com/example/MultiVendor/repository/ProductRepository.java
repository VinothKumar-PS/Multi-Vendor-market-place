package com.example.MultiVendor.repository;

import com.example.MultiVendor.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
