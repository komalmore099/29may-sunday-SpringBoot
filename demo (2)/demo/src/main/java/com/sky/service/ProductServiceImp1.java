package com.sky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sky.domain.Product;
import com.sky.repository.ProductRepository;

@Service
public class ProductServiceImp1 implements productService 
{
	@Autowired
	@Qualifier("ProductRepositoryDBImpl")
	private ProductRepository productRepository; // new ProductRepository.

	@Override
	public void addProduct(Product product) {
		System.out.println("In service");
		
		if(product.getPrice() > 20)
		{
			productRepository.addProduct(product);
		}
	}

	@Override
	public List<Product> getProducts() {
		return productRepository.getProducts();
	}
	
	public  Product getProductByid(String id)
	{
		return productRepository.getProductByid(id);
	}
	
	public void deleteById(String id)
	{
		 productRepository.deleteById(id);
		
	}

	@Override
	public void UpdateById(Product product)
	{
		 productRepository.UpdateById(product);
	}

}
