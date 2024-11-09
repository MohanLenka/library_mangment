package com.example.FlipkartClone.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Orders {
  
	@Id
	@GeneratedValue
	int id;
	@DateTimeFormat
	Date orderdate;
	 String Status;
	 int total_amount;
	 @ManyToOne()
	 @JoinColumn(name="userid")
	 Users user;
	 @ManyToOne
	 @JoinColumn(name="categorie")
	 Categories categorie;
	 @ManyToOne
	 @JoinColumn(name="orderid")
	 Products product;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public int getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Categories getCategorie() {
		return categorie;
	}
	public void setCategorie(Categories categorie) {
		this.categorie = categorie;
	}
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}
	
}
