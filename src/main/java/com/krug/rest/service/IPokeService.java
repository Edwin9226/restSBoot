package com.krug.rest.service;

import com.krug.rest.model.Poke;

import java.util.List;

public interface IPokeService {
    Poke saveBook(Poke poke);

    void deleteBook(Long id);

    List<Poke> findAllBooks();
}
