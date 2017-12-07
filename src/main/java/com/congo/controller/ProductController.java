package com.congo.controller;

import com.congo.domain.Product;
import com.congo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/product/{id}")
    public ModelAndView index(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("product");

        Product product = productService.getProduct(id);
        modelAndView.addObject("name", product.getName());
        modelAndView.addObject("description", product.getDescription());
        modelAndView.addObject("price", product.getPrice());
        modelAndView.addObject("imageUrl", "/images/" + product.getImageUrl());
        modelAndView.addObject("url", product.getUrl());

        return modelAndView;
    }

    @GetMapping("/product")
    public Product getProduct(Integer id){
        return productService.getProduct(id);
    }

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
