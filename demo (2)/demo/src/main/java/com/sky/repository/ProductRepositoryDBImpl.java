package com.sky.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sky.domain.Product;
@Repository("ProductRepositoryDBImpl")
public class ProductRepositoryDBImpl implements ProductRepository
{

	private static String INSERT_PRODUCT_SQL = "insert into product1(PRODUCT_ID,PRODUCT_NAME,PRODUCT_PRICE)values(?,?,?)";
	private static String ALL_PRODUCT_SQL = "select * from product1";
	private static String SELECT_PRODUCTBYID_SQL = "select * from product1 WHERE PRODUCT_ID=? ";
	private static String DELETE_PRODUCTBYID_SQL = "DELETE from product1 WHERE PRODUCT_ID=? ";
	private static String UPDATE_PRODUCTBYID_SQL = "UPDATE product1 SET PRODUCT_NAME=?,PRODUCT_PRICE=? WHERE PRODUCT_ID=?";
	
	private static final class ProductRowMapper implements RowMapper<Product>
	{
		public Product mapRow(ResultSet rs,int rownum)throws SQLException
		{
			Product product=new Product();
			product.setProductId(rs.getString("product_Id"));
			product.setProductName(rs.getString("product_Name"));
			product.setPrice(rs.getInt("product_price"));
			return product;
		}
	}
			
			
			@Autowired
			private JdbcTemplate jdbcTemplate;

			@Override
			public void addProduct(Product product) {
				jdbcTemplate.update(INSERT_PRODUCT_SQL,product.getProductId(),product.getProductName(),product.getPrice());
			}

			@Override
			public List<Product> getProducts() {
				return this.jdbcTemplate.query(ALL_PRODUCT_SQL, new ProductRowMapper());

			}

			@Override
			public Product getProductByid(String PRODUCT_ID) {
				  return this.jdbcTemplate.queryForObject
						  ( SELECT_PRODUCTBYID_SQL,
						    new Object[]{PRODUCT_ID}, new ProductRowMapper());
				
			}

			@Override
			public void deleteById(String PRODUCT_ID) {
				  this.jdbcTemplate.update(DELETE_PRODUCTBYID_SQL,PRODUCT_ID);
				
			}

			@Override
			public void UpdateById(Product product) {
				       
								
				this.jdbcTemplate.update(UPDATE_PRODUCTBYID_SQL,    product.getProductName(), product.getPrice(),
				        product.getProductId());
			}
	
}
