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

	private Integer userId;
	private String salutation;
	private String firstName;
	private String lastName;
	private String middleName;
	private String userName;
	private String userEmail;
	private String password;
	private String address;
	private String city;
	private Integer postalCode;
	private String mobileNumber;
	private Integer isActive;
	private Date cretedAt;
	private Date updateAt;
	private String roleType;
	private Integer bid;

}

