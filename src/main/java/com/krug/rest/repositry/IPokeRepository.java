package com.krug.rest.repositry;

import com.krug.rest.model.Poke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPokeRepository extends JpaRepository<Poke, Long> {
}
