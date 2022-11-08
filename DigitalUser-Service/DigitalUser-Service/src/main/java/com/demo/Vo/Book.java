package com.demo.Vo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
	
	private static final long serialVersionUID=1L;

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer bid;
	private String bookTitle;
	private String bookContent;
	private String category;
	private String bookAuthorName;
	private String publisherName;
	@Lob
	@Column(name = "imagepath", length = 1000)
	private byte[] imagepath;
	private String price;
	private Date createdAt;
	private Date updatedAt;
	private String isActive;
	private String userId;

}

