package com.chainsys.product.dao;

import java.util.Set;

import com.chainsys.product.model.Product;
import java.util.List;
public interface ProductDAO {
	Set<Product> findAll();
	List<String> findAllName();
	
	Product findById(int id);
	Product findByname(String name);
	void save(Product product);

	void update(Product product);
	void updatedate(Product product);
    
	void delete(int id);

	void deletebyname(String name);


	
}
