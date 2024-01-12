package com.app.ms.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ms.dto.Theatre;
import com.app.ms.entities.Movie;
import com.app.ms.entities.MovieTheatre;
import com.app.ms.service.MovieService;

@RestController
@RequestMapping("/ms/api/1.0")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.saveMovie(movie);
    }

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/movies/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @GetMapping("/movies/{movieid}/theatre/{theatreid}")
    public MovieTheatre registerMovieToTheatre(@PathVariable Long movieid, @PathVariable Long theatreid) {
        return movieService.registerMovieToTheatre(movieid, theatreid);
    }

    @GetMapping("/movies/{id}/theatres")
    public List<Theatre> getTheatreByMovieId(@PathVariable Long id) {
        return movieService.getTheatreByMovieId(id);
    }

    //GET /ms/api/1.0//movies/filter - Filter movies by cities, languages, and genres
}
