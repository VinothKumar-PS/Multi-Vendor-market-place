package com.example.MultiVendor.service;

import com.example.MultiVendor.entity.Vendor;
import com.example.MultiVendor.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public Vendor getVendorById(Long id) {
        Optional<Vendor> vendor = vendorRepository.findById(id);
        return vendor.orElse(null);
    }

    public Vendor createVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public Vendor updateVendor(Long id, Vendor vendor) {
        vendor.setId(id);
        return vendorRepository.save(vendor);
    }

    public void deleteVendor(Long id) {
        vendorRepository.deleteById(id);
    }
}
