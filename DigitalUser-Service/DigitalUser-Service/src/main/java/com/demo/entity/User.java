package com.demo.entity;

import java.io.Serializable;
import java.util.Date;
import com.demo.util.Salutation;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User implements Serializable {
	
	private static final long serialVersionUID=1L;
	
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
