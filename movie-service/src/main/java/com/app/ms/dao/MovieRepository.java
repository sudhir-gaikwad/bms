package com.app.ms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ms.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
