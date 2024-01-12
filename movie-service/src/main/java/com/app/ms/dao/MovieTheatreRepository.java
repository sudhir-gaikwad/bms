package com.app.ms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ms.entities.MovieTheatre;

public interface MovieTheatreRepository extends JpaRepository<MovieTheatre, Long> {

    List<MovieTheatre> findByMovieId(Long movieId);

}
