package com.book.bookservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_book")
public class Book {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	public Book() {
		
	}
	private String author;
	
	public Book(Integer id, String name, String author) {
		
		this.id = id;
		this.name = name;
		this.author = author;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	

}
