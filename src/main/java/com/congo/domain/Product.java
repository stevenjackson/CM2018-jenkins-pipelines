package com.congo.domain;

public class Product {
    private Integer id;
    private String name;
    private String price;
    private String url;
    private String imageUrl;

    public Product(){}

    public Product(Integer id, String name, String price, String url, String imageUrl){
        this.id = id;
        this.name = name;
        this.price = price;
        this.url = url;
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
