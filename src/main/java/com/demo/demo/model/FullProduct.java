package com.demo.demo.model;

public class FullProduct {

    private Integer product_id;

    private String name;

    private Integer stock_count;

    private String price;

    public FullProduct(Integer product_id, String name, Integer stock_count, String price) {
        this.product_id = product_id;
        this.name = name;
        this.stock_count = stock_count;
        this.price = price;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock_count() {
        return stock_count;
    }

    public void setStock_count(Integer stock_count) {
        this.stock_count = stock_count;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    
    
}
