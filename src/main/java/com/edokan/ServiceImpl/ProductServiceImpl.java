package com.edokan.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.edokan.Entity.Product;
import com.edokan.Repositiry.ProductRepository;
import com.edokan.Service.ProductService;

@Service
@Component
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Optional<Product> getProduct(Integer pId) {

		return productRepository.findByProductId(pId);
	}

	@Override
	public Product updateProduct(Product product) {
		
		Optional<Product> prod=productRepository.findByProductId(product.getpId());
		if(prod.isPresent()) {
			
			productRepository.save(product);
		}
		else {
			return null;
		}
		return product;
	}

	@Override
	public Product saveProduct(Product product) {
		
		return 	productRepository.save(product);
	}


}
