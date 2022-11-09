package com.demo.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.Exception.BusinessException;
import com.demo.Exception.ControllerException;
import com.demo.Vo.ResponseTemplateVO;
import com.demo.entity.User;
import com.demo.repository.UserBookRepository;
import com.demo.service.UserBookServiceImpl;


@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("/user")
public class UserBookController {
	
	@Autowired
	private UserBookServiceImpl userBookServiceImpl;
	
	@Autowired
	private UserBookRepository userBookRepository;
	
	@PostMapping("/")
	public ResponseEntity<?> saveUser(@RequestBody User user){
		try {
			System.out.println("Start controller saveDepartment method");
			User userSave = this.userBookServiceImpl.createUser(user);
			return new ResponseEntity<User>(userSave,HttpStatus.CREATED);
		}catch(BusinessException be) {
			   ControllerException ce = new ControllerException(be.getErrorCode(),be.getErrorMessage());
			   return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<com.demo.Exception.ControllerException>(HttpStatus.BAD_REQUEST);
		}
	  
	}
	
	@GetMapping("/{bookId}")
	public ResponseTemplateVO findByBookId(@PathVariable("bookId") Integer bookId) {
		System.out.println("Start controller findByDepId method");
		return userBookServiceImpl.getUserwithBook(bookId);
	}
	
	@RequestMapping(value="/create" , method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User user){
		
		JSONObject obj = new JSONObject();
		try {
			User isExist = userBookRepository.findByEmailUser(user.getUserEmail());
			if(isExist != null && isExist.getIsActive().equals(0)) {
				obj.put("data", "UserAccount is already available");
			}else {
				userBookServiceImpl.createUser(user);	
				obj.put("data", "User Account Successfully Created");
			}
		}catch(Exception e) {
			e.printStackTrace();
			obj.put("data", "Somthing went wrong");
			return new ResponseEntity<> (obj, HttpStatus.CONFLICT);
		}		
		return new ResponseEntity<> (obj,HttpStatus.OK);		
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody User user){
		System.out.println("Start Add User Method()");
		User saveUser = this.userBookServiceImpl.addUser(user);
		return new ResponseEntity<User>(saveUser,HttpStatus.CREATED);
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User userData){
		User user= userBookRepository.findByUserName(userData.getUserName());
		
		if(user.getRoleType().equals(userData.getRoleType())) {
			if(user.getPassword().equals(userData.getPassword())){
				return ResponseEntity.ok(user);
			}
			else {
				return (ResponseEntity<?>) ResponseEntity.internalServerError();
			}
		}
		else {
			return (ResponseEntity<?>) ResponseEntity.internalServerError();
			//return ResponseEntity.status(HttpStatus.FORBIDDEN)
            //.body("This user role is not correct , Please select correct role. !!");
		}
		
	}



}
