package com.krug.rest.serviceimp;

import com.krug.rest.model.Poke;
import com.krug.rest.repositry.IPokeRepository;
import com.krug.rest.service.IPokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokeServiceImpl implements IPokeService {
    @Autowired
    private IPokeRepository bookRepository;

    @Override
    public Poke saveBook(Poke poke){
        return bookRepository.save(poke);
    }

    @Override
    public void deleteBook(Long id){
    bookRepository.deleteById(id);
    }
    @Override
    public List<Poke> findAllBooks(){
        return bookRepository.findAll();
    }



}
