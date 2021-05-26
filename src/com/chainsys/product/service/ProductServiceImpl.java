package com.chainsys.product.service;
import java.time.LocalDate;
import java.util.Set;
import java.util.List;
import com.chainsys.product.dao.ProductDAO;
import com.chainsys.product.dao.ProductDAOImpl;
import com.chainsys.product.exception.ProductNotFoundException;
import com.chainsys.product.model.Product;
import com.chainsys.product.service.ProductService;

public class ProductServiceImpl implements ProductService {
	private static ProductDAO dao;

	public ProductServiceImpl() {
		dao = new ProductDAOImpl();
	}

	@Override
	public Set<Product> findAll() {
		return dao.findAll();
	}
	public List<String> findAllName() {
		return dao.findAllName();
	}



	@Override
	public Product findById(int id) throws ProductNotFoundException {
		Product Product = dao.findById(id);
		if (Product == null) {
			throw new ProductNotFoundException("Product Id Not Found");
		} else {
			return Product;
		}
	}

	@Override
	public void save(Product Product) {
		dao.save(Product);

	}

	@Override
	public void update(Product Product) throws ProductNotFoundException {
		Product result = dao.findById(Product.getId());
		if (result == null) {
			throw new ProductNotFoundException("Product Id Not Found");
		} else {
			dao.update(Product);
		}

	}

	@Override
	public void delete(int id) throws ProductNotFoundException {
		Product Product = dao.findById(id);
		if (Product == null) {
			throw new ProductNotFoundException("Product doesn't exist!!");
		} else {
			dao.delete(id);
		}
	}
	@Override
	public void deletebyname(String name) throws ProductNotFoundException {
		Product Product = dao.findByname(name);
		if (Product == null) {
			throw new ProductNotFoundException("Product doesn't exist!!");
		} else {
			dao.deletebyname(name);
		}
	}

	@Override
	public Product findByname(String name) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findByName(String name) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update_expire(Product uppro) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Product findByDate(LocalDate date) throws ProductNotFoundException {
		Product Product = dao.findByDate(date);
		if (Product == null) {
			throw new ProductNotFoundException("Product Name Not Found");
		} else {
			return Product;
		}
	}
	@Override
	@Override
	public void delete(LocalDate date) throws ProductNotFoundException {
		Product Product = dao.findByDate(date);
		if (Product == null) {
			throw new ProductNotFoundException("Product doesn't exist!!");
		} else {
			dao.delete(date);
		}		
	}
}
	
	

	