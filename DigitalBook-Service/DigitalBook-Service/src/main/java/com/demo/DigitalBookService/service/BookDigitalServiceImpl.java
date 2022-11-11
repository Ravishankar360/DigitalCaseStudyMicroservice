package com.demo.DigitalBookService.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import com.demo.DigitalBookService.entity.Book;
import com.demo.DigitalBookService.repository.BookRepository;

@Service
public class BookDigitalServiceImpl implements BookDigitalService {
	
	@Autowired
	private BookRepository bookRepo;
	
	
	@Override
	public List<Book> getAllBook() {
		List<Book> bookList = bookRepo.findAll();
		if(bookList != null && ! bookList.isEmpty()) {
			return bookList;
		}else {
			return null;
		}
		
	}

	public Book addBook(Book book) {
		bookRepo.save(book);
		return book;
	}

	@Override
	public Book updateBook(Integer bookId, Book book) {
		Book book1 = bookRepo.getById(bookId);
		
		if (!book.getBookAuthorName().isBlank())
			book1.setBookAuthorName(book.getBookAuthorName());
		else
			book1.setBookAuthorName(book1.getBookAuthorName());

		if (!book.getPublisherName().isBlank())
			book1.setPublisherName(book.getPublisherName());
		else
			book1.setPublisherName(book1.getPublisherName());

		if (!book.getPrice().isBlank())
			book1.setPrice(book.getPrice());
		else
			book1.setPrice(book1.getPrice());

		if (!book.getBookTitle().isBlank())
			book1.setBookTitle(book.getBookTitle());
		else
			book1.setBookTitle(book1.getBookTitle());

		if (!book.getCategory().isBlank())
			book1.setCategory(book.getCategory());
		else
			book1.setCategory(book1.getCategory());
		
		book1.setUpdatedAt(new Date());

		if (!book.getBookContent().isBlank())
			book1.setBookContent(book.getBookContent());
		else
			book1.setBookContent(book1.getBookContent());
		
		if (!book.getIsActive().isBlank())
			book1.setIsActive(book.getIsActive());
		else
			book1.setIsActive(book1.getIsActive());

		bookRepo.save(book1);
		return book1;
	}

	@Override
	public void deleteBook(Integer bookId) {
		Book book = bookRepo.getOne(bookId);
		bookRepo.delete(book);
		
	}

	public Book getBookId(Integer bookId) {
		// TODO Auto-generated method stub
		return bookRepo.getOne(bookId);
	}

	public Book saveBook(Book book) {
		bookRepo.save(book);
		return book;
	}

	public Book addfileBook(Book book, MultipartFile file) {
		 String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		 Book book1 = new Book();
	     book1.setBookAuthorName(book.getBookAuthorName());
		 book1.setBookContent(fileName);
		 book1.setBookTitle(fileName);
		 book1.setCategory(fileName);
		 book1.setIsActive(fileName);
         book1.setPrice(fileName);
         book1.setCreatedAt(new Date());
         book1.setUpdatedAt(new Date());
         book1.setPublisherName(fileName);
		
		try {
		   if(fileName.contains("..")) {
            throw new IOException("Sorry! Filename contains invalid path sequence " + fileName);
           }
		   System.out.println("After File Uploading related");
		   book1.setImagepath(file.getBytes());
		   bookRepo.save(book);
		   
		 }catch(IOException io) {
           System.out.println(io);
         }
		return book1;
	}

	public Book getBookdetails(Integer bid) {
		return bookRepo.getById(bid);
	}

	public List<Book> searchBook(Book book) {
	
		List<Book> book1 = new ArrayList<>();
		
		if(!book.getBookTitle().isEmpty() && !book.getBookAuthorName().isEmpty() && !book.getPublisherName().isEmpty()) {
		   book1 = bookRepo.findByTitleAuthorPublishder(book.getBookTitle(),book.getBookAuthorName(),book.getPublisherName());
		}else if(!book.getBookTitle().isEmpty() && !book.getBookAuthorName().isEmpty() || book.getPublisherName().isEmpty()) {
		   book1 = bookRepo.findByTitleAuthor(book.getBookTitle(),book.getBookAuthorName());
	    }else if (!book.getBookTitle().isEmpty() && !book.getPublisherName().isEmpty() || book.getBookAuthorName().isEmpty()) { 
	       book1 = bookRepo.findByTitlePublishder(book.getBookTitle(),book.getPublisherName());
	    }else if (!book.getBookTitle().isEmpty() || book.getPublisherName().isEmpty() || book.getBookAuthorName().isEmpty()) { 
		   book1 = bookRepo.findByTitle(book.getBookTitle());
		}else if ( !book.getPublisherName().isEmpty() || book.getBookTitle().isEmpty() || book.getBookAuthorName().isEmpty()) { 
		   book1 = bookRepo.getPublisherName(book.getPublisherName());
		}else if ( !book.getBookAuthorName().isEmpty() || book.getBookTitle().isEmpty() || book.getPublisherName().isEmpty()) { 
		   book1 = bookRepo.getBookAuthorName(book.getBookAuthorName());
		}else if ( book.getBookAuthorName().isEmpty() || book.getBookTitle().isEmpty() || book.getPublisherName().isEmpty()) {
			book1 = bookRepo.findAll();
		}
	    
		return book1;
	}

	public Object createBook(Book book) {
		bookRepo.save(book);
		return "CREATED";
	}

	public Book findBookById(Integer bookId) {
		Book book = bookRepo.getById(bookId);
		return book;
	}

	public Book saveBookWithImage(Book book, MultipartFile imagePath) throws IOException {

		Book book1 = new Book();
		book1.setImageName(imagePath.getOriginalFilename());
		book1.setImageType(imagePath.getContentType());
		book1.setImagepath(imagePath.getBytes());
		bookRepo.save(book1);
		return book1;
	
	}



}
