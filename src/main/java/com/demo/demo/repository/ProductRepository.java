package com.demo.demo.repository;

import com.demo.demo.model.Product;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAll();

    default Map<Integer, Product> findAllMap() {
        return findAll().stream().collect(Collectors.toMap(Product::getProduct_id, v -> v));
    }
}
