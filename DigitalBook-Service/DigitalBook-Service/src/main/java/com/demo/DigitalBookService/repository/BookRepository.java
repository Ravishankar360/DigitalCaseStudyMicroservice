package com.demo.DigitalBookService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.DigitalBookService.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	
	@Query("Select b from Book b where b.isActive=1")
	List<Book> getAllBookList() ;

//	@Query("SELECT m FROM Book m WHERE AND j.bookTitle LIKE %:bookTitle% AND ad.bookAuthorName LIKE %:bookAuthorName% AND ad.publisherName LIKE %:publisherName%")
//	List<Book> findByTitleAuthorPublishder();

	@Query("SELECT b FROM Book b WHERE b.bookTitle LIKE %:bookTitle% AND b.bookAuthorName LIKE %:bookAuthorName% AND b.publisherName LIKE %:publisherName%")
	List<Book> findByTitleAuthorPublishder(String bookTitle, String bookAuthorName, String publisherName);

	@Query("SELECT b FROM Book b WHERE b.bookTitle LIKE %:bookTitle% AND b.bookAuthorName LIKE %:bookAuthorName%")
	List<Book> findByTitleAuthor(String bookTitle, String bookAuthorName);

	@Query("SELECT b FROM Book b WHERE b.bookTitle LIKE %:bookTitle% AND b.publisherName LIKE %:publisherName%")
	List<Book> findByTitlePublishder(String bookTitle, String publisherName);
 
	@Query("SELECT b FROM Book b WHERE b.bookTitle LIKE %:bookTitle%")
	List<Book> findByTitle(String bookTitle);

	@Query("SELECT b FROM Book b WHERE b.publisherName LIKE %:publisherName%")
	List<Book> getPublisherName(String publisherName);

	@Query("SELECT b FROM Book b WHERE b.bookAuthorName LIKE %:bookAuthorName%")
	List<Book> getBookAuthorName(String bookAuthorName);


}
