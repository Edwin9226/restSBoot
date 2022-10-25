package com.krug.rest.controller;

import com.krug.rest.model.Poke;
import com.krug.rest.service.IPokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/poke")//pre/path
public class PokeController {
@Autowired
    private IPokeService bookService;

    @PostMapping//api/book
    public ResponseEntity<?> saveBook(@RequestBody Poke poke)
    {
        return new ResponseEntity<>(bookService.saveBook(poke), HttpStatus.CREATED);
    }

    @DeleteMapping("{pokeId}")
    public ResponseEntity<?> deleteBook(@PathVariable Long pokeId ){
        bookService.deleteBook(pokeId);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping//api/book
    public ResponseEntity<?> getAllBooks()
    {
        return new ResponseEntity<>(bookService.findAllBooks(),HttpStatus.OK);
    }
}
