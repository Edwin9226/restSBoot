package com.krug.rest.serviceimp;

import com.krug.rest.model.Book;
import com.krug.rest.repositry.IBookRepository;
import com.krug.rest.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id){
    bookRepository.deleteById(id);
    }
    @Override
    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }



}
