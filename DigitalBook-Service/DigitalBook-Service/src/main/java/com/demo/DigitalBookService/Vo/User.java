package com.demo.DigitalBookService.Vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.demo.DigitalBookService.Util.Salutation;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{
	
	@Id
	private Integer userId;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@Enumerated(EnumType.STRING)
	private Salutation salutation;
	private String firstName;
	private String lastName;
	private String userName;
	private String userEmail;
	private String password;
	private String address;
	private String city;
	private String postalCode;
	private Integer mobileNumber;
	private Integer isActive;
	private Date cretedAt;
	private Date updateAt;
	private Integer bookId;

}

