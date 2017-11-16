package com.congo.service;
import com.congo.domain.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    protected Map<Integer, Product> products;

    public ProductService(){
        this.products = new HashMap<Integer, Product>();

        Product firstProduct = new Product(
                1,
                "product history product",
                "a",
                "b"
        );

        Product secondProduct = new Product(
                2,
                "related product",
                "a",
                "b"
        );

        Product thirdProduct = new Product(
                3,
                "trending product",
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

    public List<Product> productHistory(Integer userId){
        List<Product> products = new ArrayList<Product>();
        products.add(this.products.get(1));
        return products;
    }

    public List<Product> relatedProducts(Integer userId){
        List<Product> products = new ArrayList<Product>();
        products.add(this.products.get(2));
        return products;
    }

    public List<Product> trendingProducts(){
        List<Product> products = new ArrayList<Product>();
        products.add(this.products.get(3));
        return products;
    }
}
