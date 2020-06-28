package com.ohar.pdbserver.repository;

import com.ohar.pdbserver.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("select p from Person p where p.fio like concat('%', :search, '%') or p.address like concat('%', :search, '%')")
    List<Person> findByFioOrAddressLike(@Param("search") String search);

    @Query("select p from Person p where p.id in :ids")
    List<Person> findByPersonIds(@Param("ids") List<Long> ids);
}
