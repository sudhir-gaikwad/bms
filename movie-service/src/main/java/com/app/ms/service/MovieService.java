package com.app.ms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.ms.dao.MovieRepository;
import com.app.ms.dao.MovieTheatreRepository;
import com.app.ms.dto.Theatre;
import com.app.ms.entities.Movie;
import com.app.ms.entities.MovieTheatre;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieTheatreRepository movieTheatreRepository;

    private static final String THEATRE_SERVICE_URL = "http://localhost:8082/ts/api/1.0/ts/theatres/details/";

    private final RestTemplate restTemplate;

    @Autowired
    public MovieService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long movieId) {
        return movieRepository.findById(movieId).orElse(null);
    }

    public MovieTheatre registerMovieToTheatre(Long movieid, Long theatreid) {
        MovieTheatre mt = new MovieTheatre();
        mt.setMovieId(movieid);
        mt.setTheatreId(theatreid);
        return movieTheatreRepository.save(mt);
    }
    
    public List<Theatre> getTheatreByMovieId(Long movieId) {

        List<MovieTheatre> theatres = movieTheatreRepository.findByMovieId(movieId);
        List<Long> theatreIds = new ArrayList<Long>();
        for (MovieTheatre m : theatres) {
            theatreIds.add(m.getTheatreId());
        }

        return restTemplate.postForObject("http://localhost:8082/ts/api/1.0/theatres/details", theatreIds,
                List.class);
    }
}
