package com.demo.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.repository.ProductNameRepository;
import com.demo.demo.repository.ProductRepository;
import com.demo.demo.model.Product;
import com.demo.demo.model.ProductName;
import com.demo.demo.model.FullProduct;

@RestController
@RequestMapping("/api")
public class ProductController {
    
    private final HashMap<String, String> locales;

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final ProductNameRepository productNameRepository;

    public ProductController(ProductRepository productRepository, ProductNameRepository productNameRepository){
        this.productRepository = productRepository;
        this.productNameRepository = productNameRepository;

        locales = new HashMap<String, String>();
        locales.put("def", "USD");
        locales.put("tr_TR", "TRY");
        locales.put("en_US", "USD");
        locales.put("en_UK", "GBP");
        locales.put("fr_FR", "EUR");
        locales.put("jp_JP", "YEN");
    }

    @GetMapping("/get")
    public ResponseEntity<List<FullProduct>> getAll(@RequestParam(required = false, name = "locale") String locale){
        ArrayList<FullProduct> finalProducts = new ArrayList<FullProduct>();

        Map<Integer, Product> products = productRepository.findAllMap();
        Map<Integer, ProductName> productNames = productNameRepository.findAllMap();

        for(Integer productId : products.keySet()) {
            finalProducts.add(new FullProduct(
                productId,
                productNames.keySet().contains(productId)? productNames.get(productId).getName(locale == null? "def": locale): null,
                products.get(productId).getStock_count(),
                products.get(productId).getPrice()
            ));
        }

        return ResponseEntity.ok(finalProducts);
    }
    
}
