package com.app.ts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ts.dao.TheatreRepository;
import com.app.ts.entities.Theatre;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    public Theatre saveTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    public Theatre getTheatreById(Long theatreId) {
        return theatreRepository.findById(theatreId).orElse(null);
    }

    public List<Theatre> getTheatreDetailsForTheatreIds(List<Long> theatreIds) {
        return theatreRepository.findTheatreForTheatreIds(theatreIds);
    }
}
