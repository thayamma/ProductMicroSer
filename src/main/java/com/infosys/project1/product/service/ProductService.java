package com.infosys.project1.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.project1.product.dto.ProductDTO;
import com.infosys.project1.product.entity.Product;
import com.infosys.project1.product.repository.ProductRepository;
import com.infosys.project1.product.validator.ProductValidator;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	

	public List<ProductDTO> getproducts(){
		List<Product> product= productRepository.findAll();
		List<ProductDTO> productDTO= new ArrayList<ProductDTO>();
		for(Product p1: product) {
			ProductDTO product1= ProductDTO.valueof(p1);
			productDTO.add(product1);
		}
		return productDTO;	
	}
	public List<ProductDTO> getProductsOnCategory(String category){
		List<Product> cate= productRepository.findAll();
		List<ProductDTO> productDTO= new ArrayList<ProductDTO>();
		for(Product c1: cate) {
			if(c1.getCategory().equals(category)) {
			ProductDTO product1= ProductDTO.valueof(c1);
			productDTO.add(product1);
			}
		}
		return productDTO;	
	}
	public List<ProductDTO> getProductsOnName(String productname){
		List<Product> name= productRepository.findAll();
		List<ProductDTO> productDTO= new ArrayList<ProductDTO>();
		for(Product c1: name) {
			if(c1.getProductName().equals(productname)) {
			ProductDTO product1= ProductDTO.valueof(c1);
			productDTO.add(product1);
			}
		}
		return productDTO;	
	}
	public ProductDTO getProductsOnId(Integer prodid) {
		ProductDTO product1 = null;
		Optional<Product> product= productRepository.findById(prodid);
		if(product.isPresent()) {
//		ProductDTO productDTO= new ProductDTO();
		if(prodid.equals(product.get().getProdid())) {
			product1= ProductDTO.valueon(product);
			
	}}return product1;}

	public void addproducts(ProductDTO productdto) throws Exception{
		ProductValidator.ProdValidate(productdto);
		System.out.println("2");
		Product pe=productdto.createEntity();
		productRepository.save(pe);
		System.out.println("1");
	}
	
	public void deleteproducts(Integer prodid) {
		
			productRepository.deleteById(prodid);
		
		
	}}


