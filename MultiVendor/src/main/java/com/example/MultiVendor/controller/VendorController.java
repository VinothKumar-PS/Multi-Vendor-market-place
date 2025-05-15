package com.example.MultiVendor.controller;

import com.example.MultiVendor.entity.Vendor;
import com.example.MultiVendor.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @GetMapping
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @GetMapping("/{id}")
    public Vendor getVendorById(@PathVariable Long id) {
        return vendorService.getVendorById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorService.createVendor(vendor);
    }

    @PutMapping("/{id}")
    public Vendor updateVendor(@PathVariable Long id, @RequestBody Vendor vendor) {
        return vendorService.updateVendor(id, vendor);
    }

    @DeleteMapping("/{id}")
    public void deleteVendor(@PathVariable Long id) {
        vendorService.deleteVendor(id);
    }
}
