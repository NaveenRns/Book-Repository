package com.book.bookservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.bookservice.model.Book;
import com.book.bookservice.service.BookService;

@RestController
@RequestMapping("/bookapi")
public class BookController {

	@Autowired
	BookService bookService; 
	
	@GetMapping("/book/")
	public ResponseEntity<List<Book>> getAllBooks(){
		
		List<Book> books = bookService.findAllBooks();
		
		if(books.isEmpty()) {
			
			return new ResponseEntity<List<Book>>(books, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(books, HttpStatus.OK);
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<?> getBook(@PathVariable Integer id){
		
		Book book = bookService.findBookById(id);
		
		if(book == null) {
			
			return new ResponseEntity<>("Book not Found with Id", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(book,HttpStatus.OK);
		
	}
	
	@PostMapping("/book/")
	public ResponseEntity<?> createBook(@RequestBody Book book){
		
		bookService.save(book);
		
		return new ResponseEntity<>(book,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/book/{id}")
	public ResponseEntity<?> updateBook(@PathVariable Integer id,@RequestBody Book book){
		
		Book bookById = bookService.findBookById(id);
		
		if(bookById == null) {
			
			return new ResponseEntity<>("Unable to Update",HttpStatus.NOT_FOUND);
			
		}
		
		bookById.setName("Welcome to Lab");
		bookById.setAuthor("Naveen");
		
		bookService.updateBook(bookById,id);
		return new ResponseEntity<>(bookById, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/book/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable Integer id){
		
		Book book = bookService.findBookById(id);
		
		if(book == null) {
			
			return new ResponseEntity<>("not Found",HttpStatus.NOT_FOUND);
		}
		
		bookService.deleteBookById(id);
		
		return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
		
	}
	
	@DeleteMapping("/book/")
	public ResponseEntity<?> deleteBooks(){
	
		bookService.deleteAllBooks();
		
		return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
		
	}
	
}
