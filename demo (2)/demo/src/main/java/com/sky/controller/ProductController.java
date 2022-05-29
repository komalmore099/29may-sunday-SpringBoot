package com.sky.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sky.domain.Product;
import com.sky.service.productService;

@Controller
@RequestMapping("/products")
public class ProductController 
{
	@Autowired
	private productService productservice;
	
	@RequestMapping(value="/product",method=RequestMethod.GET,consumes = "application/json", produces ="application/json")
	public @ResponseBody List<Product> getProducts()
	{
	return productservice.getProducts();
	
	}
	
	@RequestMapping(value="/product",method=RequestMethod.POST,consumes = "application/json", produces ="application/json")
	public @ResponseBody Product addProduct(@RequestBody Product product) 
	{
	System.out.println(product);
	productservice.addProduct(product);
	return product;
	}


	@RequestMapping(value="/product/{id}",method=RequestMethod.GET,consumes = "application/json", produces ="application/json")
	public @ResponseBody Product
	getProductByid( @PathVariable("id")String id )
		{
		return productservice.getProductByid(id);
		}
	
	@RequestMapping(value="/product/{id}",method=RequestMethod.DELETE,consumes = "application/json", produces ="application/json")
	public @ResponseBody void
	deleteById(@PathVariable("id")String id)
	{
		productservice.deleteById(id);
	}
	
	@RequestMapping(value="/product",method=RequestMethod.PUT,consumes = "application/json", produces ="application/json")
	public @ResponseBody void UpdateById(@RequestBody Product NProd)
	{
		 productservice.UpdateById(NProd);
	}
	
}
