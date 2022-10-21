package com.demo.DigitalBookService.service;

import java.util.List;

import com.demo.DigitalBookService.entity.Book;

public interface BookDigitalService {
	
	List<Book> getAllBook();

	public Book addBook(Book book);

	public Book updateBook(Book book);

	public void deleteBook(Integer bookId);

}
