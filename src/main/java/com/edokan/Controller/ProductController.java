package com.edokan.Controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.edokan.Entity.Product;

import com.edokan.Service.ProductService;
import com.edokan.sorting.ProductNameCompare;
import com.edokan.sorting.SortByProductType;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	
Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/health")
	public String health()
	{
		logger.info("inside ProductControllerr health method");
		return "ProductController  wokring!!!..";
	}

	@GetMapping("/all")
	public List<Product> getAllProducts()
	{
		logger.info("inside getAllProducts controller");
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse> getProduct(@PathVariable Integer id)
	{
		logger.info("inside getProductById controller");
		Optional<Product> product=productService.getProduct(id);
		if((product.isPresent())){
			 ApiResponse response = new ApiResponse(200, "Success", product.get());
	            return ResponseEntity.ok().body(response);
	        } else {
	            ApiResponse response = new ApiResponse(404, "User not found", null);
	            return ResponseEntity.status(HttpStatus.OK).body(response);
	        }
	}
	@PutMapping("/update")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product)
	{
		logger.info("inside update employee method!!!!");
		return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(product));
	}
	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product)
	{
		logger.info("inside save employee method!!!!");
		return ResponseEntity.status(HttpStatus.OK).body(productService.saveProduct(product));
	}

	@GetMapping("/sortByName")
	public List<Product> sortByName()
	{
		logger.info("inside sortByName controller");
		List<Product> allProduct=productService.getAllProducts();
		Collections.sort(allProduct, new ProductNameCompare());
		return allProduct;
	}
	@GetMapping("/sortByProductType")
	public List<Product> sortByProductType()
	{
		logger.info("inside sortByName controller");
		List<Product> allProduct=productService.getAllProducts();
		//Collections.sort(allProduct, new SortByProductType().reversed()); //reverser order sort
		Collections.sort(allProduct, new SortByProductType()); //ascending  order shot
		return allProduct;
	}

}
