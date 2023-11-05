package com.uttam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uttam.entity.Product;
import com.uttam.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping( value="/products", consumes= {"application/json"},
	             produces= {"application/json"})//for create product
	public String saveProduct(@RequestBody Product product) {
		String msg = null;
		Product saveProduct = productService.saveProduct(product);
		
		if (saveProduct.getPid()!= null) {
			msg= "Product data saved...";
		}else {
			msg = "Product failed to save...";
		}
		return msg;
	}
	//retrieve product
	@GetMapping("/{pid}")
	public List<Product> getAllProduct(@PathVariable Long pid){
		return productService.getAllProducts();
	}
	
	// for update product
	@PutMapping("/{pid}")
	public Product updateProduct(@PathVariable Long pid,@RequestBody  Product product) {
		return productService.updateProduct(pid, product);
	}
	
	//for delete product
	@DeleteMapping("/{pid}")
	public String deleteProduct(@PathVariable Long pid) {
		productService.deleteProduct(pid);
		return "product deleted";
	}
	

}
