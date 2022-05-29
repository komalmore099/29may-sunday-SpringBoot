package com.sky.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sky.domain.Product;

@Repository
public class ProductRepositoryImp1  implements ProductRepository
{
	
	private static List<Product> products =new ArrayList<Product>();
	

	@Override
	public void addProduct(Product product) 
	{
		System.out.println("In repository");
		products.add(product);
	}

	@Override
	public List<Product> getProducts() {
		return products;
	}
	
	

	@Override
	public Product getProductByid(String id) {
		for(Product prod:products)
		{
			if(prod.getProductId().equals(id))
		     return prod;
		}	return null;
	}
	
	public void deleteById(String id)
	{
		int index=0;
		for(Product prod:products)
		{
			if(prod.getProductId().equals(id))
			{
				  products.remove(index);
				 
				
			}
			index=index+1;
		}
		//return null;
	 }
	
	public void UpdateById(Product NProd)
	{
		int index=0;
		for(Product prod:products)
		{
			if(prod.getProductId().equals(NProd.getProductId()))
			{
				products.set(index, NProd);
//				  	  return NProd;
				
			}
			index=index+1;
		}
	//	return null;
		
	}
}
