package com.app.ts.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.ts.entities.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {

    @Query("SELECT t FROM Theatre t WHERE t.id IN :theatreIds")
    List<Theatre> findTheatreForTheatreIds(List<Long> theatreIds);
}
