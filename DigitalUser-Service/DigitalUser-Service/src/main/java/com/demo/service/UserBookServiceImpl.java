package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.Vo.Book;
import com.demo.Vo.ResponseTemplateVO;
import com.demo.entity.User;
import com.demo.repository.UserBookRepository;

@Service
public class UserBookServiceImpl implements UserBookService{

	
	@Autowired
	private UserBookRepository userBookRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public User createUser(User user) {
		return userBookRepository.save(user);
	}
	
	public ResponseTemplateVO getUserwithBook(Integer bid) {
		ResponseTemplateVO response = new ResponseTemplateVO();
		User user = userBookRepository.findByUserId(bid);
		ResponseEntity<Book> book = restTemplate.getForEntity("http://localhost:5000/book/"+user.getBid(),Book.class);
	    response.getUser();
	    response.getBook();
		return response;
	}

	
    public User addUser(User user) {
    		User userdata = userBookRepository.save(user);
    		return userdata;
	}
	
}
