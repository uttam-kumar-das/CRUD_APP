package com.uttam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uttam.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
