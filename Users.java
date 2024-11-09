package com.example.FlipkartClone.entity;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Users {
 
	@Id
	@GeneratedValue
	int id;
	String name;
	String email;
	String password;
	long ph_no;
	String role;
	@OneToMany(cascade = CascadeType.ALL,mappedBy ="user",fetch=FetchType.LAZY)
	List<Orders> orders;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.LAZY)
	List<Review> review;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.LAZY)
	List<CartItem> cartitem;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.LAZY)
	List<WishList> wishitems;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPh_no() {
		return ph_no;
	}
	public void setPh_no(long ph_no) {
		this.ph_no = ph_no;
	}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	public List<Review> getReview() {
		return review;
	}
	public void setReview(List<Review> review) {
		this.review = review;
	}
	public List<CartItem> getCartitem() {
		return cartitem;
	}
	public void setCartitem(List<CartItem> cartitem) {
		this.cartitem = cartitem;
	}
	public List<WishList> getWishitems() {
		return wishitems;
	}
	public void setWishitems(List<WishList> wishitems) {
		this.wishitems = wishitems;
	}
	
	
}
