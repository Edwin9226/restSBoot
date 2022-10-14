package com.krug.rest.service;

import com.krug.rest.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IBookService  {
    Book saveBook(Book book);

    void deleteBook(Long id);

    List<Book> findAllBooks();
}
