package com.demo.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.repository.ProductNameRepository;
import com.demo.demo.repository.ProductRepository;
import com.demo.demo.model.Product;
import com.demo.demo.model.ProductName;
import com.demo.demo.model.CreateProductBody;
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
        Double conversionRate = 1.0;
        try {
            String from = locales.get("def");
            String to = locale == null? locales.get("def") : locales.getOrDefault(locale, locales.get("def"));
            conversionRate = Currency.getRate(from, to);
        } catch (Exception e) {
            System.out.println("Something wrong with conversino API");
        }

        Map<Integer, Product> products = productRepository.findAllMap();
        Map<Integer, ProductName> productNames = productNameRepository.findAllMap();

        for(Integer productId : products.keySet()) {
            Product tempProduct = products.get(productId);
            ProductName tempProductName = productNames.get(productId);

            String name = productNames.keySet().contains(productId)? tempProductName.getName(locale) : null;
            
            Double defaultPrice = tempProduct.getPrice() != null? tempProduct.getPrice() : 0.0;
            Double resultPrice = defaultPrice*conversionRate;
            String price = String.format("%.2f %s", resultPrice, locales.getOrDefault(locale, locales.get("def")));

            FullProduct tempFullProduct = new FullProduct(
                productId,
                name,
                tempProduct.getStock_count(),
                price
            );

            finalProducts.add(tempFullProduct);
        }

        return ResponseEntity.ok(finalProducts);
    }

    @PostMapping("/create")
    public ResponseEntity<CreateProductBody> create(@RequestBody CreateProductBody createProductBody) {
        Product product = new Product(
            createProductBody.getProduct_id(),
            createProductBody.getStock_count(),
            createProductBody.getPrice()
        );

        ProductName productName = new ProductName(
            createProductBody.getProduct_id(),
            createProductBody.getName(),
            createProductBody.getTr_TR(),
            createProductBody.getEn_US(),
            createProductBody.getEn_UK(),
            createProductBody.getFr_FR(),
            createProductBody.getJp_JP()
        );

        if(productRepository.existsById(createProductBody.getProduct_id())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(createProductBody);
        }

        productRepository.save(product);
        productNameRepository.save(productName);

        return ResponseEntity.status(HttpStatus.CREATED).body(createProductBody);
    }
    
    @PutMapping("/update")
    public ResponseEntity<CreateProductBody> put(@RequestBody CreateProductBody createProductBody) {
        if (createProductBody.getProduct_id() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(createProductBody);
        } else if (!productRepository.existsById(createProductBody.getProduct_id())) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(createProductBody);
        }

        Product product = new Product(
            createProductBody.getProduct_id(),
            createProductBody.getStock_count(),
            createProductBody.getPrice()
        );

        ProductName productName = new ProductName(
            createProductBody.getProduct_id(),
            createProductBody.getName(),
            createProductBody.getTr_TR(),
            createProductBody.getEn_US(),
            createProductBody.getEn_UK(),
            createProductBody.getFr_FR(),
            createProductBody.getJp_JP()
        );

        productRepository.deleteById(createProductBody.getProduct_id());
        productNameRepository.deleteById(createProductBody.getProduct_id());

        productRepository.save(product);
        productNameRepository.save(productName);
        
        return ResponseEntity.status(HttpStatus.OK).body(createProductBody);
    }
}
