package com.congo.controller;

import com.congo.domain.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {


    @GetMapping("/productHistory")
    public List<Product> productHistory() {
        return new ArrayList<Product>();
    }

    @GetMapping("/relatedProducts")
    public List<Product> relatedProducts() {
        return new ArrayList<Product>();
    }

    @GetMapping("/trendingProducts")
    public List<Product> trendingProducts() {
        return new ArrayList<Product>();
    }
}
