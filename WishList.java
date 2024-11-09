package com.example.FlipkartClone.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
@Entity
public class WishList {

	 @Id
	    @GeneratedValue
	    int Id;
	 @ManyToOne
	    @JoinColumn(name="user")
	    Users user;
	 @OneToOne
	   Products product;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}
}
