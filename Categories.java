package com.example.FlipkartClone.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categories {
    @Id
    @GeneratedValue
    int id;
    String name;
    String description;
    @OneToMany(cascade = CascadeType.ALL,mappedBy ="categorie",fetch = FetchType.LAZY)
    List<Products> products;
    @OneToMany(cascade = CascadeType.ALL,mappedBy ="categorie",fetch = FetchType.LAZY)
    List<Orders> orders;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Products> getProducts() {
		return products;
	}
	public void setProducts(List<Products> products) {
		this.products = products;
	}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
}
