package org.example.web.repository;

import org.example.web.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {

    List<Film> findAllByCustomer_Id(Integer customerId);

    @Query(nativeQuery = true, value = "select * from Film where name like %:name%")
    List<Film> searchByName(String name);
}
