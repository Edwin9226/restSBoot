package com.krug.rest.repositry;

import com.krug.rest.model.Rol;
import com.krug.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    @Modifying
    @Query("update User set role = :role where username= :username")
    void updateUserRole(@Param("username") String username, @Param("role")Rol role);
}
