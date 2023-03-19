package com.demo.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "products")
public class Product {
    @Id
    private Integer product_id;

    @Column(name = "stockCount")
    private int stock_count;
    
    @Column(name = "price")
    private Double price;

    public Product() {

    }

    public Product(Integer productId, int stockCount, Double price) {
        this.product_id = productId;
        this.stock_count = stockCount;
        this.price = price;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public int getStock_count() {
        return stock_count;
    }

    public void setStock_count(int stock_count) {
        this.stock_count = stock_count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
