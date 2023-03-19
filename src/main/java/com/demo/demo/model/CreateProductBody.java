package com.demo.demo.model;

public class CreateProductBody {
    private Integer product_id;
    private Integer stock_count;
    private double price;
    private String name;
    private String tr_TR;
    private String en_US;
    private String en_UK;
    private String fr_FR;
    private String jp_JP;
    
    public CreateProductBody(Integer product_id, Integer stock_count, double price, String name, String tr_TR,
            String en_US, String en_UK, String fr_FR, String jp_JP) {
        this.product_id = product_id;
        this.stock_count = stock_count;
        this.price = price;
        this.name = name;
        this.tr_TR = tr_TR;
        this.en_US = en_US;
        this.en_UK = en_UK;
        this.fr_FR = fr_FR;
        this.jp_JP = jp_JP;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getStock_count() {
        return stock_count;
    }

    public void setStock_count(Integer stock_count) {
        this.stock_count = stock_count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTr_TR() {
        return tr_TR;
    }

    public void setTr_TR(String tr_TR) {
        this.tr_TR = tr_TR;
    }

    public String getEn_US() {
        return en_US;
    }

    public void setEn_US(String en_US) {
        this.en_US = en_US;
    }

    public String getEn_UK() {
        return en_UK;
    }

    public void setEn_UK(String en_UK) {
        this.en_UK = en_UK;
    }

    public String getFr_FR() {
        return fr_FR;
    }

    public void setFr_FR(String fr_FR) {
        this.fr_FR = fr_FR;
    }

    public String getJp_JP() {
        return jp_JP;
    }

    public void setJp_JP(String jp_JP) {
        this.jp_JP = jp_JP;
    }

    
    
}
