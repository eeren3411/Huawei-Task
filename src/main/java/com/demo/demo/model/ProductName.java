package com.demo.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productNames")
public class ProductName {
    
    @Id
    private Integer product_id;

    @Column(name = "def")
    private String def;

    @Column(name = "tr_TR")
    private String tr_TR;

    @Column(name = "en_US")
    private String en_US;

    @Column(name = "en_UK")
    private String en_UK;

    @Column(name = "fr_FR")
    private String fr_FR;

    @Column(name = "jp_JP")
    private String jp_JP;

    public ProductName() {

    }

    public ProductName(Integer product_id, String def, String tr_TR, String en_US, String en_UK, String fr_FR,
            String jp_JP) {
        this.product_id = product_id;
        this.def = def;
        this.tr_TR = tr_TR;
        this.en_US = en_US;
        this.en_UK = en_UK;
        this.fr_FR = fr_FR;
        this.jp_JP = jp_JP;
    }

    public String getName(String locale) {
        String name = null;
        switch (locale) {
            case "tr_TR":
                name = this.tr_TR; break;
            case "en_US":
                name = this.en_US; break;
            case "en_UK":
                name = this.en_UK; break;
            case "fr_FR":
                name = this.fr_FR; break;
            case "jp_JP":
                name = this.jp_JP; break;
        }
        return name == null? this.def : name;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getDef() {
        return def;
    }

    public void setDef(String def) {
        this.def = def;
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
