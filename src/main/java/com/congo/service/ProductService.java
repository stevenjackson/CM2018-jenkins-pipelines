package com.congo.service;
import com.congo.domain.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {

    protected Map<Integer, Product> products;

    public ProductService(){
        this.products = new HashMap<Integer, Product>();

        Product firstProduct = new Product(
                1,
                "widget 1",
                "a",
                "b"
        );

        Product secondProduct = new Product(
                2,
                "widget 1",
                "a",
                "b"
        );

        Product thirdProduct = new Product(
                3,
                "widget 1",
                "a",
                "b"
        );

        this.products.put(1, firstProduct);
        this.products.put(2, secondProduct);
        this.products.put(3, thirdProduct);
    }

    public Map<Integer, Product> getAllProducts(){
        if(this.products == null){
            this.products = new HashMap<Integer, Product>();
        }
        return this.products;
    }

    public Product getProduct(Integer id) {
        return getAllProducts().get(id);
    }
}
