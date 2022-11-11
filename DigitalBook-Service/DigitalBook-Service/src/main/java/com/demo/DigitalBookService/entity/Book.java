package com.demo.DigitalBookService.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "book")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book {
	
	private static final long serialVersionUID = 6396100319470393108L;
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer bid;
	private String bookTitle;
	private String bookContent;
	private String category;
	private String bookAuthorName;
	private String publisherName;
	private String price;
	private Date createdAt;
	private Date updatedAt;
	private String isActive;
	private String userId;
	
	@Column(name = "imagepath", unique = false, nullable = true, length = 100000)
	private byte[] imagepath;

	@Column(name = "imageName")
	private String imageName;

	@Column(name = "imageType")
	private String imageType;
	
	
	

}
