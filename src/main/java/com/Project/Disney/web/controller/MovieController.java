package com.Project.Disney.web.controller;

import com.Project.Disney.service.MovieService;
import com.Project.Disney.web.dto.ResponseIdDto;
import com.Project.Disney.web.dto.ResponseMovieDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/disney")
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ResponseMovieDto> findByName(@PathVariable String name) {
        ResponseMovieDto movie = service.findByName(name);
        return ResponseEntity.ok(movie);
    }

    @GetMapping
    public ResponseEntity<List<ResponseMovieDto>> findAll() {
        List<ResponseMovieDto> movie = service.findAll();
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ResponseIdDto> findById(@PathVariable Long id) {
        ResponseIdDto movie = service.findById(id);
        return ResponseEntity.ok(movie);
    }
}
