package com.example.MultiVendor.controller;

import com.example.MultiVendor.entity.Product;
import com.example.MultiVendor.entity.Vendor;
import com.example.MultiVendor.service.ProductService;
import com.example.MultiVendor.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;

@Controller
public class WebViewController {

    @Autowired
    private ProductService productService;

    @Autowired
    private VendorService vendorService;

    // Home route
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/products")
    public String showProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("product", new Product());
        model.addAttribute("vendors", vendorService.getAllVendors()); // REQUIRED for dropdown
        return "productsList";
    }

    // Save new product
    @PostMapping("/products")
    public String saveProduct(@ModelAttribute Product product) {
        productService.createProduct(product);
        return "redirect:/products";

    }

    // Edit product
    @GetMapping("/products/edit/{id}")
    public String editProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));  // Ensure valid product ID is passed
        return "product_edit";
    }

    // Update product
    @PostMapping("/products/update")
    public String updateProduct(@ModelAttribute Product product) {
        productService.updateProduct(product.getId(), product);
        return "redirect:/products";
    }

    // Delete product
    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";

    }

    // Show vendors
    @GetMapping("/vendors")
    public String showVendors(Model model) {
        model.addAttribute("vendors", vendorService.getAllVendors());
        model.addAttribute("vendor", new Vendor());
        return "vendors";
    }

    // Save new vendor
    @PostMapping("/vendors")
    public String saveVendor(@ModelAttribute Vendor vendor) {
        vendorService.createVendor(vendor);
        return "redirect:/vendors";
    }

    // Edit vendor
    @GetMapping("/vendors/edit/{id}")
    public String editVendor(@PathVariable Long id, Model model) {
        model.addAttribute("vendor", vendorService.getVendorById(id));
        return "vendor_edit";
    }

    // Update vendor
    @PostMapping("/vendors/update")
    public String updateVendor(@ModelAttribute Vendor vendor) {
        vendorService.updateVendor(vendor.getId(), vendor);
        return "redirect:/vendors";
    }

    // Delete vendor
    @GetMapping("/vendors/delete/{id}")
    public String deleteVendor(@PathVariable Long id) {
        vendorService.deleteVendor(id);
        return "redirect:/vendors";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Vendor.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                Long vendorId = Long.parseLong(text);
                setValue(vendorService.getVendorById(vendorId));
            }
        });
    }



}
