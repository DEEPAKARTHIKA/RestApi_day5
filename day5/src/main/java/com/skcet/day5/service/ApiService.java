package com.skcet.day5.service;

import java.util.List;

import com.skcet.day5.model.Book;

public interface ApiService {
   public List<Book> getBook();

public boolean addBook(Book book);

public boolean updateBook(Long id,Book book);

public boolean deleteBook(Long id);

}
