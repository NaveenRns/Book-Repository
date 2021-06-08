package com.book.bookservice.service;

import java.util.List;

import com.book.bookservice.model.Book;

public interface BookService {

	List<Book> findAllBooks();

	Book findBookById(Integer id);

	void save(Book book);

	void updateBook(Book bookById,Integer id);

	void deleteBookById(Integer id);

	void deleteAllBooks();

}
