package com.example.MultiVendor.repository;

import com.example.MultiVendor.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
