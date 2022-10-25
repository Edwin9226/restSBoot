package com.krug.rest.repositry;

import com.krug.rest.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {
}
