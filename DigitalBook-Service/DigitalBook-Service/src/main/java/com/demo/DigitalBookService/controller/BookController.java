package com.demo.DigitalBookService.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.DigitalBookService.Exception.BusinessException;
import com.demo.DigitalBookService.Exception.ControllerException;
import com.demo.DigitalBookService.entity.Book;
import com.demo.DigitalBookService.repository.BookRepository;
import com.demo.DigitalBookService.service.BookDigitalServiceImpl;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {
	
	@Autowired
	private BookDigitalServiceImpl bookServiceimpl;
	
	@Autowired
	private BookRepository bookRepo;
	
	
	@PostMapping("/addbook")
	public ResponseEntity<?> addbook(@RequestBody Book book){
		try {
			System.out.println("Start controller saveBook method");
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
	
	@PostMapping("/addbookWithImage")
	public ResponseEntity<?> addbook(@RequestBody Book book, @RequestParam("imagePath") MultipartFile imagePath) throws IOException{
		try {
			System.out.println("Start controller saveBook method");
			Book bookSave= this.bookServiceimpl.saveBookWithImage(book,imagePath);
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
	public Book findByBookId(@PathVariable("bookid") Integer bookid) {
		System.out.println("Start controller findByBookId method");
		return bookServiceimpl.getBookId(bookid);
	}
	
	@PostMapping("/addBookWithImage")
	public Book addBookwithImage(@RequestParam Book book, @RequestParam("imagepath") MultipartFile file){
		System.out.println("Start addBookWithImage :- "+ book.getBookTitle() +" ! "+book.getBookContent());
		return this.bookServiceimpl.addfileBook(book,file);
	}
	
	@GetMapping("/getBookData")
	public List<Book> getAllStudent(){
		List<Book> bookList = bookServiceimpl.getAllBook();
		return bookList;
	}
	
	@PutMapping("/updateBook/{bookId}")
	public Book updateBook(@PathVariable Integer bookId ,@RequestBody Book book){
		return this.bookServiceimpl.updateBook(bookId,book);
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
	
	@GetMapping("/getBooks/{bid}")
	public Book getBookDetails(@PathVariable Integer bid){
		return this.bookServiceimpl.getBookdetails(bid);
	}
	
	
	
	@DeleteMapping(path = { "/books/{bookId}" })
	public Book deleteUser(@PathVariable("bid") Integer bookId) {
		Book book = bookRepo.getOne(bookId);
		this.bookServiceimpl.deleteBook(bookId);
		return book;
	}	

	@PostMapping("/searchbook")
	public List<Book> searchBook(@RequestBody Book book){
		try {
			System.out.println("Start controller searchBook method");
			List<Book> bookSearch= (List<Book>) this.bookServiceimpl.searchBook(book);
			return bookSearch;
		}catch(Exception e) {
			e.printStackTrace();
			return (List<Book>) e;
		}
	}
	
	@PostMapping("/upload/image")
	public ResponseEntity<Object> uplaodLogo(@RequestParam("imagePath") MultipartFile imagePath) throws IOException {

		Book book = new Book();
		book.setImageName(imagePath.getOriginalFilename());
		book.setImageType(imagePath.getContentType());
		// .logo((logo.getBytes())).build();
		book.setImagepath(imagePath.getBytes());
		return ResponseEntity.status(HttpStatus.OK).body((bookServiceimpl.createBook(book)));
	}
	
	@GetMapping(value = "/get/image/{bookId}", produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getLogo(@PathVariable("bookId") Integer bookId) throws IOException {

		final Book dbImage = bookServiceimpl.findBookById(bookId);

		return ResponseEntity.ok().contentType(MediaType.valueOf(dbImage.getImageType())).body((dbImage.getImagepath()));

	}
	
	
}
