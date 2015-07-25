package com.model;

import java.io.Serializable;

public class Movie implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String title;
	private String category;
	
	public Movie(){
		this.title = "";
		this.category = "";
	}
	
	public Movie(String title, String category){
		this.title = title;
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}	
	

}

