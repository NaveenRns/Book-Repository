package com.book.bookservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.bookservice.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
