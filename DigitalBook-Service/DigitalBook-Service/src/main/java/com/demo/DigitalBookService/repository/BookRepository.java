package com.demo.DigitalBookService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.DigitalBookService.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	
	@Query("Select b from Book b where b.is_active=1")
	List<Book> getAllBookList() ;


}
