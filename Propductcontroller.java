package com.example.FlipkartClone.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.FlipkartClone.entity.Products;
import com.example.FlipkartClone.repository.ProductRepo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin
public class Propductcontroller {

	@Autowired
	ProductRepo productrepo;
	@GetMapping("/users/getproducts/{des}")
	public Object getMethodName(@PathVariable String des) {
		List<Products> allproducts=productrepo.findByDesContains(des);
		return allproducts;
	}
	
}
