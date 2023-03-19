package com.demo.demo.repository;

import com.demo.demo.model.ProductName;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductNameRepository extends JpaRepository<ProductName, Integer> {
    List<ProductName> findAll();

    default Map<Integer, ProductName> findAllMap() {
        return findAll().stream().collect(Collectors.toMap(ProductName::getProduct_id, v -> v));
    }
}
