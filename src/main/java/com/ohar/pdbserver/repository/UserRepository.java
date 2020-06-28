package com.ohar.pdbserver.repository;

import com.ohar.pdbserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select us from User us where us.login = :login")
    User findByLogin(@Param("login") String login);
}
