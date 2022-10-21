package com.demo.DigitalBookService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.DigitalBookService.entity.Book;
import com.demo.DigitalBookService.repository.BookRepository;

@Service
public class BookDigitalServiceImpl implements BookDigitalService {
	
	@Autowired
	private BookRepository bookRepo;
	
	
	@Override
	public List<Book> getAllBook() {
		List<Book> bookList = bookRepo.getAllBookList();
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
	public Book updateBook(Book book) {
		bookRepo.save(book);
		return book;
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



}
