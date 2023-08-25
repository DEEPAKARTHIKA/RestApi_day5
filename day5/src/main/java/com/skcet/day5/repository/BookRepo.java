package com.skcet.day5.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.skcet.day5.model.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{

	   boolean existsById(Long id);
	   Optional<Book> findById(Long id);
	   void deleteById(Long id);
}
