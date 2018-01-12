package com.niit.portalbackend;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Blog {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int blogId;
	private String blogName;
	private String blogDescription;
	private boolean approved;
	
	@ManyToOne
	private portal_user user;
	private int likes;
	private Date blogDate;
	
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getBlogName() {
		return blogName;
	}
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}
	public String getBlogDescription() {
		return blogDescription;
	}
	public void setBlogDescription(String blogDescription) {
		this.blogDescription = blogDescription;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public portal_user getUser() {
		return user;
	}
	public void setUser(portal_user user) {
		this.user = user;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public Date getBlogDate() {
		return blogDate;
	}
	public void setBlogDate(Date blogDate) {
		this.blogDate = blogDate;
	}
	

}