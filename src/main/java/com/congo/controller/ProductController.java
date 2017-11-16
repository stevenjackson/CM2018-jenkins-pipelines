package com.congo.controller;

import com.congo.domain.Product;
import com.congo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/productHistory")
    public List<Product> productHistory(Integer userId) {
        return productService.productHistory(userId);
    }

    @GetMapping("/relatedProducts")
    public List<Product> relatedProducts(Integer userId) {
        return productService.relatedProducts(userId);
    }

    @GetMapping("/trendingProducts")
    public List<Product> trendingProducts() {
        return productService.trendingProducts();
    }
}
