package com.uttam.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uttam.entity.Product;
import com.uttam.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@SuppressWarnings("deprecation")
	public Product getProductById(Long pid) {
		return productRepository.getById(pid);
	}
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	public Product updateProduct(Long pid, Product product) {
		if(productRepository.existsById(pid)) {
			product.setPid(pid);
			return productRepository.save(product);
		}
		return null;
		
	
	}
	public void deleteProduct(Long pid) {
		productRepository.deleteById(pid);
	
	}

}
