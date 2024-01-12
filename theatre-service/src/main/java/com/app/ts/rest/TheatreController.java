package com.app.ts.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ts.entities.Theatre;
import com.app.ts.service.TheatreService;

@RestController
@RequestMapping("/ts/api/1.0")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @PostMapping("/theatres")
    public Theatre addTheatre(@RequestBody Theatre theatre) {
        return theatreService.saveTheatre(theatre);
    }

    @GetMapping("/theatres")
    public List<Theatre> getAllTheatres() {
        return theatreService.getAllTheatres();
    }

    @GetMapping("/theatres/{id}")
    public Theatre getTheatreById(@PathVariable Long id) {
        return theatreService.getTheatreById(id);
    }

    @PostMapping("/theatres/details")
    public List<Theatre> getTheatresForTheatreIds(@RequestBody List<Long> theatreIds) {
        return theatreService.getTheatreDetailsForTheatreIds(theatreIds);
    }
}
