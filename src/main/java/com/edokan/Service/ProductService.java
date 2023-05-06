package com.edokan.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edokan.Entity.Product;

@Service
public interface ProductService {

	List<Product> getAllProducts();

	Optional<Product> getProduct(Integer pId);

	Product updateProduct(Product product);

	Product saveProduct(Product product);

}
