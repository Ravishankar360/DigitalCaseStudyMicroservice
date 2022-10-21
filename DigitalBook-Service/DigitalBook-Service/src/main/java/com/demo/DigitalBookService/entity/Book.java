package com.demo.DigitalBookService.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookId;
	private String bookName;
	private String bookContent;
	private String category;
	private String bookAuthorName;
	private String publisherName;
	private String imagepath;
	private String price;
	private Date Created_at;
	private Date Updated_at;
	private int is_active;
	
	

}
