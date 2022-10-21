package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.entity.User;

@Repository
public interface UserBookRepository extends JpaRepository<User, Integer>{

	@Query("Select u from User u where u.userEmail =:userEmail")
	User findByEmailUser(String userEmail);

	User findByUserId(Integer userId);

}
