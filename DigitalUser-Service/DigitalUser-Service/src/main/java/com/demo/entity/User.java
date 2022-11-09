package com.demo.entity;

import java.io.Serializable;
import java.util.Date;
import com.demo.util.Salutation;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User implements Serializable {
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
