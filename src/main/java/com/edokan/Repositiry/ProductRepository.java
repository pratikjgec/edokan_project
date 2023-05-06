package com.edokan.Repositiry;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edokan.Entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

	//Optional<Product> findByPId(Integer id);
	@Query(value = "SELECT * FROM Product WHERE p_id = :pId", nativeQuery = true)
	Optional<Product> findByProductId(@Param("pId") Integer pId);

	
}
