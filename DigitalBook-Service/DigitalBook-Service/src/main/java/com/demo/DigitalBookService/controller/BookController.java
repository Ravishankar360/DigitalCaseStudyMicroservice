package com.demo.DigitalBookService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.DigitalBookService.Exception.BusinessException;
import com.demo.DigitalBookService.Exception.ControllerException;
import com.demo.DigitalBookService.entity.Book;
import com.demo.DigitalBookService.service.BookDigitalServiceImpl;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookDigitalServiceImpl bookServiceimpl;
	
	
	@PostMapping("/")
	public ResponseEntity<?> saveBook(@RequestBody Book book){
		try {
			System.out.println("Start controller saveDepartment method");
			Book bookSave= this.bookServiceimpl.saveBook(book);
			return new ResponseEntity<Book>(bookSave,HttpStatus.CREATED);
		}catch(BusinessException be) {
			   ControllerException ce = new ControllerException(be.getErrorCode(),be.getErrorMessage());
			   return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ControllerException>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/{bookid}")
	public Book findByDepartmentId(@PathVariable("bookid") Integer bookid) {
		System.out.println("Start controller findByBookId method");
		return bookServiceimpl.getBookId(bookid);
	}
	
	@GetMapping("/getBookData")
	public List<Book> getAllStudent(){
		List<Book> bookList = bookServiceimpl.getAllBook();
		return bookList;
	}
	
	@PostMapping("/addBook")
	public Book addCourse(@RequestBody Book book){
		return this.bookServiceimpl.addBook(book);
	}
	
	@PostMapping("/updateBook/{bookId}")
	public Book updateCourse(@RequestBody Book book){
		return this.bookServiceimpl.updateBook(book);
	}
	
	@DeleteMapping("/deleteBook/{bookId}")
	public ResponseEntity<HttpStatus> deleteBook(@PathVariable Integer bookId){
		try {
			this.bookServiceimpl.deleteBook(bookId);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
