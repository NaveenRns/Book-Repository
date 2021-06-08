package com.book.bookservice.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.bookservice.dao.BookRepository;
import com.book.bookservice.model.Book;
import com.book.bookservice.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	
	  @Autowired 
	  BookRepository bookRepository;
	 

	@Override
	public List<Book> findAllBooks() {
		List<Book> bookList = bookRepository.findAll();
		
		return bookList;
	}

	@Override
	public Book findBookById(Integer id) {
		
		Optional<Book> book = bookRepository.findById(id);
 
		return book.get();
	}

	@Override
	public void save(Book book) {
		
		bookRepository.save(book);
		
		
		
	}

	@Override
	public void updateBook(Book bookById,Integer id) {
		
		bookById.setName("Welcome");
		bookById.setAuthor("Santosh");
		
		
		bookRepository.save(bookById);
		
		
	}

	@Override
	public void deleteBookById(Integer id) {
		bookRepository.deleteById(id);
		
	}

	@Override
	public void deleteAllBooks() {
		bookRepository.deleteAll();
		
	}

}
