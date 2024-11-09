package com.example.FlipkartClone.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {
   @Id
   @GeneratedValue
   int ReviewId;
   String commant;
   int rating;
   @ManyToOne
   @JoinColumn(name="userid")
   Users user;
   @ManyToOne
   @JoinColumn(name="productid")
   Products product;
public int getReviewId() {
	return ReviewId;
}
public void setReviewId(int reviewId) {
	ReviewId = reviewId;
}
public String getCommant() {
	return commant;
}
public void setCommant(String commant) {
	this.commant = commant;
}
public int getRating() {
	return rating;
}
public void setRating(int rating) {
	this.rating = rating;
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
