package com.skcet.day5.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skcet.day5.model.Book;
import com.skcet.day5.service.ApiService;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class ApiServiceImpl implements ApiService{
	@Autowired
	private BookRepo bookRepo;
	
	@Override
	public boolean addBook(Book book) {
		boolean userExists=bookRepo.existsById(book.getId());
		if(!userExists) {
			bookRepo.save(book);
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public List<Book> getBook(){
		return bookRepo.findAll();
		}
	
	@Override
	public boolean updateBook(Long id,Book book) {
//		userRepository.saveAndFlush(userClass);
		Optional<Book>existingUserOptional=bookRepo.findById(id);
		if(existingUserOptional.isPresent()) {
		Book userExists=existingUserOptional.get()	;
		userExists.setBookName(book.getBookName());
		userExists.setPrice(book.getPrice());
		userExists.setQuantity(book.getQuantity());
		userExists.setAuthorName(book.getAuthorName());
		bookRepo.save(userExists);
				return true;
		}
	else {
		return false;
	}
	}
	@Override
	public boolean deleteBook(Long id) {
		
		Optional<Book> existingUserOptional = bookRepo.findById(id);
		if(existingUserOptional.isPresent()) {
			bookRepo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	
}
