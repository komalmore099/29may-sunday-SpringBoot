package com.sky.service;

import java.util.List;

import com.sky.domain.Product;

public interface productService 
{
	
	public void addProduct(Product product);
	public List<Product> getProducts();
	public Product getProductByid(String id);
	public void deleteById(String id);
	public void UpdateById(Product NProd);
	

}
