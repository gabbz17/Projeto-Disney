package com.Project.Disney.web.controller;

import com.Project.Disney.entity.People;
import com.Project.Disney.service.PeopleService;
import com.Project.Disney.web.dto.PeopleRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/people")
public class PeopleController {

    public final PeopleService service;

    public PeopleController(PeopleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody PeopleRequestDto dto) {
        People created = service.create(dto);
        return ResponseEntity.status(201).body("Usuário criado com sucesso!");
    }
}
